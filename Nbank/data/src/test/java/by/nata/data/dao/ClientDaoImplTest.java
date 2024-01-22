package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.entity.Client;
import by.nata.data.entity.Currency;
import by.nata.data.entity.Role;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigurationTest.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
//@Transactional
public class ClientDaoImplTest {
@Autowired
    private  ClientDao clientDao;
@Autowired
    private  DataSource dataSource;

    private ClientDto clientDto;
    Connection connection;

    public ClientDaoImplTest() {
    }


    @Before
    public void setUp() throws Exception {
        connection = dataSource.getConnection();
//        String clientId = UUID.randomUUID().toString();
//        String clientDetailsId = UUID.randomUUID().toString();
//        String clientAddressId = UUID.randomUUID().toString();
//        String sql1 = "insert into CLIENT_DETAILS (id, surname, name, birth_date, passport_number, identity_number, date_issue, date_expiry )" +
//                "values (" +clientDetailsId + " 'Jonson', 'Tom', '1990-05-12', 'KB565656', '364557M0757', '2020-12-12', '2027-12-12')";
//
//        String sql2 = "insert into CLIENT_ADDRESS (id, country, city, street, house_number, flat_number, phone_number )" +
//                "values (" + clientAddressId + " 'Russia', 'Moscow', 'Arbat', '135', '250', '8029363738')";
//
//        String sql = "insert into client (id, username, password, email, role, CLIENT_DETAILS, CLIENT_ADDRESS)" +
//                " values (" + clientId + " 'tom', 'tom55', 'tom@gmail.com', 'USER', 'a1', 'b1')";
//        connection.createStatement().executeUpdate(sql1);
//        connection.createStatement().executeUpdate(sql2);
//        connection.createStatement().executeUpdate(sql);


    }

    @After
    public void tearDown() throws Exception {
//        connection = dataSource.getConnection();
//        String sql1 = "delete from CLIENT_ADDRESS";
//        String sql2 = "delete from CLIENT_DETAILS";
//        String sql = "delete from client";
//        connection.createStatement().executeUpdate(sql1);
//        connection.createStatement().executeUpdate(sql2);
//        connection.createStatement().executeUpdate(sql);
        connection.close();
    }

    @Test
    public void findByUsername() {

        ClientDto foundClient = clientDao.findByUsername("admin");
        assertNotNull(foundClient);

        assertEquals("admin", foundClient.getUsername());

    }

//    @Test
//    public void deleteClientById() throws SQLException {
//        ClientDto foundClient = clientDao.findByUsername("admin");
//        clientDao.deleteClientById(foundClient.getId());
//
//        assertNull(foundClient);
//
//        assertEquals(null, foundClient.getId());
//
//    }

    @Test
    public void update() {
    }

    @Test
    public void getClientById() {
        String id = "aaaabbbbccccddddeeeeffff00000001";

        ClientDto client = clientDao.getClientById(id);

        assertNotNull(client);
        assertEquals("aaaabbbbccccddddeeeeffff00000001", client.getId());
    }

    @Test
    public void findAll() {
        List<ClientDto> clients = clientDao.findAll();

        assertNotNull(clients);
        assertEquals(1, clients.size());
    }

//    @Test
//    public void save() throws SQLException {
//                String clientId = UUID.randomUUID().toString();
//        String clientDetailsId = UUID.randomUUID().toString();
//        String clientAddressId = UUID.randomUUID().toString();
//
// ClientDetailsDto clientDetailsDto = new ClientDetailsDto(clientDetailsId, "Jonson", "Tom",
//         LocalDate.of(1990, 05, 12), "KB565656",
//         "364557M0757", LocalDate.of(2020, 12, 12),
//         LocalDate.of(2027, 12, 12));
//
// ClientAddressDto clientAddressDto =  new ClientAddressDto(clientAddressId, "Russia", "Moscow", "Arbat",
//         "135", "250", "8029363738");
//
//    clientDto = new ClientDto(clientId, "tom", "tom55", "tom@gmail.com",
//         Role.USER, clientDetailsDto, clientAddressDto);
//
//
////        clientDto = new ClientDto(clientId, "tom", "tom55", "tom@gmail.com",
////                Role.USER, new ClientDetailsDto(clientDetailsId, "Jonson", "Tom",
////                LocalDate.of(1990, 05, 12), "KB565656",
////                "364557M0757", LocalDate.of(2020, 12, 12),
////                LocalDate.of(2027, 12, 12)),
////                new ClientAddressDto(clientAddressId, "Russia", "Moscow", "Arbat",
////                        "135", "250", "8029363738"));
//
//        clientDao.save(clientDto);
//        ClientDto savedClient = clientDao.findByUsername("tom");
//
//        assertNotNull(savedClient);
//
//        assertEquals("tom", savedClient.getUsername());
//        assertEquals("tom@gmail.com", savedClient.getEmail());
////        assertEquals("USER", savedClient.getRole());
//
//        assertNotNull(savedClient.getClientDetailsDto());
//        assertEquals("Jonson", savedClient.getClientDetailsDto().getSurname());
//
//        assertNotNull(savedClient.getClientAddressDto());
//        assertEquals("Russia", savedClient.getClientAddressDto().getCountry());
//
//
//
//    }
}