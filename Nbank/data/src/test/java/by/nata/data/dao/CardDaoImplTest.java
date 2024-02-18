package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.config.NbankDataSourceTest;
import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Currency;
import by.nata.data.entity.Role;
import by.nata.data.entity.TypeOperation;
import by.nata.data.model.*;
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
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigurationTest.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class CardDaoImplTest {
    @Autowired
    AccountDao accountDao;
    @Autowired
    ClientDao clientDao;
    @Autowired
    CardDao cardDao;
    Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = NbankDataSourceTest.getConnection();
        if (connection != null) {
            connection.createStatement().executeUpdate("delete from card");
            connection.createStatement().executeUpdate("delete from account");
            connection.createStatement().executeUpdate("delete from CLIENT_ADDRESS");
            connection.createStatement().executeUpdate("delete from CLIENT_DETAILS");
            connection.createStatement().executeUpdate("delete from client");

        }
    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
        cardDao = null;
        connection = NbankDataSourceTest.getConnection();
        connection.createStatement().executeUpdate("delete from card");
        connection.createStatement().executeUpdate("delete from account");
        connection.createStatement().executeUpdate("delete from CLIENT_ADDRESS");
        connection.createStatement().executeUpdate("delete from CLIENT_DETAILS");
        connection.createStatement().executeUpdate("delete from client");
        connection.close();
    }

    @Test
    public void save() {
        Role userRole = Role.valueOf("USER");
        ClientDetailsDto expectedCD = new ClientDetailsDto(null,
                "Jonson", "Tom", LocalDate.of(1990, 05, 12),
                "KB565656", "364557M0757", LocalDate.of(2020, 12, 12),
                LocalDate.of(2027, 12, 12));
        ClientAddressDto expectedCA = new ClientAddressDto(null,
                "Russia", "Moscow", "Arbat", "135",
                "250", "8029363738");

        ClientDto expectedClient = new ClientDto(null, "tom", "tom55", "tom@gmail.com", userRole,
                expectedCD, expectedCA);
        String id = clientDao.save(expectedClient);

        ClientDto actualClient = clientDao.getClientById(id);

        assertNotNull(actualClient);

        Currency currency = Currency.valueOf("USD");
        AccountDto expectedAccount = new AccountDto();
        expectedAccount.setClientDto(actualClient);
        expectedAccount.setAccountNumber("56877t6g789nj987");
        expectedAccount.setDateOpen(ZonedDateTime.now());
        expectedAccount.setBalance(BigDecimal.valueOf(0.0));
        expectedAccount.setCurrency(currency);
        expectedAccount.setPin("3003");

        accountDao.save(expectedAccount);
        AccountDto savedAccount = accountDao.findByAccountNumber("56877t6g789nj987");

        assertNotNull(savedAccount);
        assertEquals("56877t6g789nj987", savedAccount.getAccountNumber());
        assertEquals("3003", savedAccount.getPin());

        //save card
        CardDto expectedCard = new CardDto(
                null, savedAccount, "1234567891234567", BigDecimal.valueOf(0.0),
                ZonedDateTime.now(), "333", CardStatus.valueOf("CREDIT"), currency
        );
        cardDao.save(expectedCard, savedAccount.getAccountNumber());
        CardDto savedCard = cardDao.findByCardNumber("1234567891234567");
        assertNotNull(savedCard);
        assertEquals("333", savedCard.getCvv());
    }

    @Test
    public void deleteCardByCardNumber() {
        Role userRole = Role.valueOf("USER");
        ClientDetailsDto expectedCD = new ClientDetailsDto(null,
                "Jonson", "Tom", LocalDate.of(1990, 05, 12),
                "KB565656", "364557M0757", LocalDate.of(2020, 12, 12),
                LocalDate.of(2027, 12, 12));
        ClientAddressDto expectedCA = new ClientAddressDto(null,
                "Russia", "Moscow", "Arbat", "135",
                "250", "8029363738");

        ClientDto expectedClient = new ClientDto(null, "tom", "tom55", "tom@gmail.com", userRole,
                expectedCD, expectedCA);
        String id = clientDao.save(expectedClient);

        ClientDto actualClient = clientDao.getClientById(id);

        assertNotNull(actualClient);

        Currency currency = Currency.valueOf("USD");
        AccountDto expectedAccount = new AccountDto();
        expectedAccount.setClientDto(actualClient);
        expectedAccount.setAccountNumber("56877t6g789nj987");
        expectedAccount.setDateOpen(ZonedDateTime.now());
        expectedAccount.setBalance(BigDecimal.valueOf(0.0));
        expectedAccount.setCurrency(currency);
        expectedAccount.setPin("3003");

        accountDao.save(expectedAccount);
        AccountDto savedAccount = accountDao.findByAccountNumber("56877t6g789nj987");

        assertNotNull(savedAccount);
        assertEquals("56877t6g789nj987", savedAccount.getAccountNumber());
        assertEquals("3003", savedAccount.getPin());

        //save card
        CardDto expectedCard = new CardDto(
                null, savedAccount, "1234567891234567", BigDecimal.valueOf(0.0),
                ZonedDateTime.now(), "333", CardStatus.valueOf("CREDIT"), currency
        );
        cardDao.save(expectedCard, savedAccount.getAccountNumber());
        CardDto savedCard = cardDao.findByCardNumber("1234567891234567");
        assertNotNull(savedCard);
        assertEquals("333", savedCard.getCvv());

        CardDto deleteCard = cardDao.deleteCardByCardNumber(savedCard.getCardNumber());

        assertNull(cardDao.findByCardNumber(savedCard.getCardId()));
        assertNull(deleteCard);
    }

    @Test
    public void getAllCards() {
        List<CardDto> actualCards = cardDao.getAllCards();

        assertNotNull(actualCards);
        assertEquals(0, actualCards.size());
        assertTrue(actualCards.isEmpty());
    }

    @Test
    public void findByCardNumber() {
    }
}