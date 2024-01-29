package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.config.NbankDataSourceTest;
import by.nata.data.entity.Currency;
import by.nata.data.entity.TypeOperation;
import by.nata.data.model.TransactionsDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.ZonedDateTime;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigurationTest.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")

public class TransactionsDaoImplTest {
    @Autowired
    AccountDao accountDao;
    @Autowired
    TransactionsDao transactionsDao;
    Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = NbankDataSourceTest.getConnection();
        if (connection != null) {
            connection.createStatement().executeUpdate("delete from transactions");
        }
    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
        connection = NbankDataSourceTest.getConnection();
        connection.createStatement().executeUpdate("delete from transactions");
        connection.close();
    }

    @Test
    public void save() {
        Currency currency = Currency.valueOf("USD");
        TypeOperation typeOperation = TypeOperation.TRANSFER;
        TransactionsDto expectedTransactions = new TransactionsDto(null,
                "56877t6g789nj987", "56811t6g789nj787", new BigDecimal("200.00"),
                currency, ZonedDateTime.now(), typeOperation);

        String savedTransaction = transactionsDao.save(expectedTransactions);
        assertNotNull(savedTransaction);

        TransactionsDto foundTransaction = transactionsDao.findById(savedTransaction);
        assertNotNull(foundTransaction);
        assertEquals(expectedTransactions.getAccountNumber(), foundTransaction.getAccountNumber());
        assertEquals(expectedTransactions.getAccountNumberRecipient(), foundTransaction.getAccountNumberRecipient());
        assertEquals(0, expectedTransactions.getBalance().compareTo(foundTransaction.getBalance()));
    }

    @Test
    public void findAllTransactions() {
        List<TransactionsDto> actualTransactions = transactionsDao.findAllTransactions();

        assertNotNull(actualTransactions);
        assertEquals(0, actualTransactions.size());
        assertTrue(actualTransactions.isEmpty());
    }

    @Test
    public void getTransactions() {
        int numTransactions = 10;
        for (int i = 0; i < numTransactions; i++) {
            TransactionsDto transaction = createTransaction(i);
            transactionsDao.save(transaction);
        }

        // Получаем первую страницу с определенным размером страницы
        int page = 0;
        int pageSize = 5;
        List<TransactionsDto> firstPage = transactionsDao.getTransactions(page * pageSize, pageSize);

        // Проверяем, что количество транзакций на первой странице соответствует размеру страницы
        assertEquals(pageSize, firstPage.size());

        // Получаем вторую страницу
        page = 1;
        List<TransactionsDto> secondPage = transactionsDao.getTransactions(page * pageSize, pageSize);

        // Проверяем, что количество транзакций на второй странице соответствует размеру страницы или меньше,
        // если они находятся на последней странице
        assertTrue(secondPage.size() <= pageSize);

        // Проверяем, что транзакции на второй странице не дублируются с транзакциями на первой странице
        assertFalse(firstPage.stream().anyMatch(secondPage::contains));

        // Проверяем, что общее количество транзакций равно сумме транзакций на двух страницах
        assertEquals(numTransactions, firstPage.size() + secondPage.size());
    }

    private TransactionsDto createTransaction(int index) {
        String id = "id_" + index;
        String accountNumber = "account_number_" + index;
        String accountNumberRecipient = "recipient_" + index;
        BigDecimal balance = BigDecimal.valueOf(index * 1000.00);
        Currency currency = Currency.EUR;
        ZonedDateTime date = ZonedDateTime.now();
        TypeOperation typeOperation = TypeOperation.TRANSFER;

        return new TransactionsDto(id, accountNumber, accountNumberRecipient, balance, currency, date, typeOperation);
    }
}