package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.config.NbankDataSourceTest;
import by.nata.data.entity.ClientDetails;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientFilterDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigurationTest.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class ClientDetailsDaoImplTest {
        @Autowired
        private ClientDetailsDao clientDetailsDao;

        Connection connection;
        @Before
        public void setUp() throws Exception {
            connection = NbankDataSourceTest.getConnection();
            connection.createStatement().executeUpdate("delete from CLIENT_ADDRESS");
            connection.createStatement().executeUpdate("DELETE FROM CLIENT_DETAILS;");
            connection.createStatement().executeUpdate("delete from client");
        }

        @After
        public void tearDown() throws Exception {
            clientDetailsDao = null;
            connection = NbankDataSourceTest.getConnection();
            connection.createStatement().executeUpdate("delete from CLIENT_ADDRESS");
            connection.createStatement().executeUpdate("DELETE FROM CLIENT_DETAILS;");
            connection.createStatement().executeUpdate("delete from client");
            connection.close();
        }

        @Test
        public void save() {
            ClientDetailsDto expectedCD = new ClientDetailsDto(null,
                    "Jonson", "Tom", LocalDate.of(1990, 05, 12),
                    "KB565656", "364557M0757", LocalDate.of(2020, 12, 12),
                    LocalDate.of(2027, 12, 12));


            String id = clientDetailsDao.save(expectedCD);

            assertNotNull(id);
        }


    @Test
    public void findById() {
        ClientDetailsDto expectedCD = new ClientDetailsDto(null,
                "Jonson", "Tom", LocalDate.of(1990, 05, 12),
                "KB565656", "364557M0757", LocalDate.of(2020, 12, 12),
                LocalDate.of(2027, 12, 12));

        String savedClientDetailsDto =   clientDetailsDao.save(expectedCD);
        assertNotNull(savedClientDetailsDto);

        Optional<ClientDetailsDto> result = clientDetailsDao.findById(savedClientDetailsDto);
        assertTrue(result.isPresent());
        ClientDetailsDto clientDetailsDto = result.get();
        assertEquals(savedClientDetailsDto, clientDetailsDto.getId());
        assertEquals("Jonson", clientDetailsDto.getSurname());
    }

//    @Test
//    public void findAllByFilter() {
//        ClientDetailsDto expectedCD1 = new ClientDetailsDto(null,
//                "Jonson", "Tom", LocalDate.of(1990, 05, 12),
//                "KB565656", "364557M0757", LocalDate.of(2020, 12, 12),
//                LocalDate.of(2027, 12, 12));
//
//        ClientDetailsDto expectedCD2 = new ClientDetailsDto(null,
//                "Tailor", "Nik", LocalDate.of(1995, 10, 25),
//                "KB565656", "364557M0757", LocalDate.of(2020, 12, 12),
//                LocalDate.of(2027, 12, 12));
//
//        clientDetailsDao.save(expectedCD1);
//        clientDetailsDao.save(expectedCD2);
//
//        ClientFilterDto clientFilterDto = new ClientFilterDto("Jonson", "Tom", LocalDate.of(1990, 05, 12) );
//        List<ClientDetails> clients = clientDetailsDao.findAllByFilter(clientFilterDto);
//
//        assertEquals(1, clients.size());
//        assertEquals("Jonson", clients.get(0).getSurname());
//        assertEquals("Tom", clients.get(0).getName());
//    }
}