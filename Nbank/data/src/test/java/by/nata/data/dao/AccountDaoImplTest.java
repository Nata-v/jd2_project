package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.config.NbankDataSourceTest;
import by.nata.data.entity.Account;
import by.nata.data.entity.Currency;
import by.nata.data.entity.Role;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
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

public class AccountDaoImplTest {
    @Autowired
    AccountDao accountDao;
    @Autowired
    ClientDao clientDao;
    Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = NbankDataSourceTest.getConnection();
        if (connection != null) {
            connection.createStatement().executeUpdate("delete from account");
        }
    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
        connection = NbankDataSourceTest.getConnection();
        connection.createStatement().executeUpdate("delete from account");
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
    }

    @Test
    public void updateAccount() {
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
        expectedAccount.setBalance(new BigDecimal("0.0"));
        expectedAccount.setCurrency(currency);
        expectedAccount.setPin("3003");
        accountDao.save(expectedAccount);

        BigDecimal newBalance = new BigDecimal(2000);
        expectedAccount.setBalance(newBalance);
       Account updatedAccount = accountDao.updateAccount(expectedAccount);

        assertNotNull(updatedAccount);
        assertEquals(newBalance, updatedAccount.getBalance());
    }

    @Test
    public void getAccountById() {
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
        List<AccountDto> savedAccounts = accountDao.getAccountById(id);
        assertNotNull(savedAccounts);
        for (AccountDto savedAccount : savedAccounts) {
            assertEquals(id, savedAccount.getClientDto().getId());
        }
    }

    @Test
    public void findByAccountNumber() {
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
    }

    @Test
    public void getAllAccounts() {
        List<AccountDto> actualAccounts = accountDao.getAllAccounts();

        assertNotNull(actualAccounts);
        assertEquals(0, actualAccounts.size());
        assertTrue(actualAccounts.isEmpty());
    }

    @Test
    public void deleteAccountByAccountNumber() {
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
        AccountDto deletedAccount = accountDao.deleteAccountByAccountNumber(savedAccount.getAccountId());

        assertNull(accountDao.getAccountById(savedAccount.getAccountId()));
        assertNull(deletedAccount);
    }
}