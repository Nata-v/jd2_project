package by.nata.service;

import by.nata.data.dao.ClientDao;
import by.nata.data.entity.Role;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.service.config.NbankDataSourceTest;
import by.nata.service.config.ServiceConfigurationTest;
import by.nata.service.model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfigurationTest.class)
@TestPropertySource(value = "classpath:some.properties")
public class ClientServiceImplTest {
    private static final String CLIENT_ID = "1";
    @Autowired
    private ClientService clientService;
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
    public void saveNewClient() {
        Role userRole = Role.valueOf("USER");

        ClientDto client = new ClientDto(null,
                "nata",
                "12345",
                "nata@gmail.com",
                userRole,
                new ClientDetailsDto(null,
                        "Volkova",
                        "Natali",
                        LocalDate.of(2000, 8, 31),
                        "KB232323",
                        "1235M0987",
                        LocalDate.of(2020, 10, 10),
                        LocalDate.of(2025, 10, 10)),
                new ClientAddressDto(null,
                        "Belarus",
                        "Minsk",
                        "Nemiga",
                        "6",
                        "15",
                        "25-45-55"));
        clientDao.save(client);
        verify(clientDao).save(client);
        Mockito.when(clientDao.getClientById(client.getId())).thenReturn(client);

        ClientDto actualClient = clientDao.getClientById(client.getId());
        assertNotNull(actualClient);
        assertEquals(client, actualClient);
        Mockito.verify(clientDao, Mockito.times(3)).getClientById(ArgumentMatchers.any());
        assertEquals("nata@gmail.com", actualClient.getEmail());
    }

    @Test
    public void findAllClientsTest() {
        List<Client> result = clientService.findAllClients();
        assertNotNull(result);

    }

    @Test
    public void findClientById() {
        Role userRole = Role.valueOf("USER");

        ClientDto client = new ClientDto(null,
                "nata",
                "12345",
                "nata@gmail.com",
                userRole,
                new ClientDetailsDto(null,
                        "Volkova",
                        "Natali",
                        LocalDate.of(2000, 8, 31),
                        "KB232323",
                        "1235M0987",
                        LocalDate.of(2020, 10, 10),
                        LocalDate.of(2025, 10, 10)),
                new ClientAddressDto(null,
                        "Belarus",
                        "Minsk",
                        "Nemiga",
                        "6",
                        "15",
                        "25-45-55"));
        clientDao.save(client);
        verify(clientDao).save(client);
        Mockito.when(clientDao.getClientById(client.getId())).thenReturn(client);

        Client findClient = clientService.findClientById(client.getId());
        assertEquals(client.getId(), findClient.getId());
        assertEquals("nata@gmail.com", findClient.getEmail());


    }


    @Test
    public void delete() {
        Role userRole = Role.valueOf("USER");

        ClientDto client = new ClientDto(null,
                "nata",
                "12345",
                "nata@gmail.com",
                userRole,
                new ClientDetailsDto(null,
                        "Volkova",
                        "Natali",
                        LocalDate.of(2000, 8, 31),
                        "KB232323",
                        "1235M0987",
                        LocalDate.of(2020, 10, 10),
                        LocalDate.of(2025, 10, 10)),
                new ClientAddressDto(null,
                        "Belarus",
                        "Minsk",
                        "Nemiga",
                        "6",
                        "15",
                        "25-45-55"));
        clientDao.save(client);
        verify(clientDao).save(client);
        Mockito.when(clientDao.getClientById(client.getId())).thenReturn(client);

        Client findClient = clientService.findClientById(client.getId());
        assertEquals(client.getId(), findClient.getId());
        assertEquals("nata@gmail.com", findClient.getEmail());

        ClientDto deletedClient = clientDao.deleteClientById(client.getId());

        assertNull(deletedClient);
        verify(clientDao).deleteClientById(client.getId());
        Mockito.when(clientDao.findByUsername(client.getUsername())).thenReturn(null);

    }

}