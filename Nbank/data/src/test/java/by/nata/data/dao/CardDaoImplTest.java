package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.config.NbankDataSourceTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

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
        }
    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
        cardDao = null;
        connection = NbankDataSourceTest.getConnection();
        connection.createStatement().executeUpdate("delete from card");
        connection.createStatement().executeUpdate("delete from account");
        connection.close();
    }

    @Test
    public void save() {
    }

    @Test
    public void deleteCardByCardNumber() {
    }

    @Test
    public void getAllCards() {
    }

    @Test
    public void findByCardNumber() {
    }
}