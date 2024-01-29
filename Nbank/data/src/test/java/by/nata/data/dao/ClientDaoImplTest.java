package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.config.NbankDataSourceTest;
import by.nata.data.entity.Role;
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

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigurationTest.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class ClientDaoImplTest {
    @Autowired
    private ClientDao clientDao;

    Connection connection;


    @Before
    public void setUp() throws Exception {
        connection = NbankDataSourceTest.getConnection();
        if (connection != null) {
            connection.createStatement().executeUpdate("delete from client");
            connection.createStatement().executeUpdate("delete from CLIENT_DETAILS");
            connection.createStatement().executeUpdate("delete from CLIENT_ADDRESS");
        }

        }

    @After
    public void tearDown() throws Exception {
        clientDao = null;
        connection = NbankDataSourceTest.getConnection();
        connection.createStatement().executeUpdate("delete from client");
        connection.createStatement().executeUpdate("delete from CLIENT_DETAILS");
        connection.createStatement().executeUpdate("delete from CLIENT_ADDRESS");
        connection.close();

    }

    @Test
    public void findByUsername() {
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


        clientDao.save(expectedClient);
        ClientDto savedClient = clientDao.findByUsername("tom");

        assertNotNull(savedClient);

        assertEquals("tom", savedClient.getUsername());

    }

    @Test
    public void deleteClientById() throws SQLException {
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
        ClientDto foundClient = clientDao.findByUsername("tom");
        if (foundClient != null) {
            ClientDto deletedClient = clientDao.deleteClientById(foundClient.getId());

            assertNull(clientDao.getClientById(id));
            assertNull(deletedClient);

        }
    }

    @Test
    public void update() {
    }

    @Test
    public void getClientById() {
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

        // When
        ClientDto actualClient = clientDao.getClientById(id);
        // Then
        assertNotNull(actualClient);
        assertEquals(expectedClient.getPassword(), actualClient.getPassword());
        assertEquals(expectedClient.getEmail(), actualClient.getEmail());
        assertEquals(id, actualClient.getId());

    }

    @Test
    public void findAll() {

        List<ClientDto> actualClients = clientDao.findAll();

        assertNotNull(actualClients);
        assertEquals(0, actualClients.size());
        assertTrue(actualClients.isEmpty());
    }

    @Test
    public void save() throws SQLException {
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

        clientDao.save(expectedClient);
        ClientDto savedClient = clientDao.findByUsername("tom");

        assertNotNull(savedClient);

        assertEquals("tom", savedClient.getUsername());
        assertEquals("tom@gmail.com", savedClient.getEmail());
//        assertEquals("USER", savedClient.getRole());

        assertNotNull(savedClient.getClientDetailsDto());
        assertEquals("Jonson", savedClient.getClientDetailsDto().getSurname());

        assertNotNull(savedClient.getClientAddressDto());
        assertEquals("Russia", savedClient.getClientAddressDto().getCountry());



    }
}