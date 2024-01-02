package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.entity.*;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = DataConfigurationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDaoImplTest {
    private static final String CLIENT_ID = "1";
    private static final String CLIENT_DETAILS_ID = "2";
    private static final String CLIENT_ADDRESS_ID = "3";

    @Mock
    private ClientDao clientDao;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void delete() {
//        ClientDto client = new ClientDto(
//        client.setId(CLIENT_ID);
//        client.setUsername("Meta");
//        client.setPassword("12345");
//        client.setEmail("nata@gmail.com");
//        client.setClientDetails(client.getClientDetails());
//        client.setClientAddress(client.getClientAddress()));
//
//        System.out.println(client);
//    }

    @Test
    public void update() {
    }

//    @Test
//    public void findById() {
//       Optional<ClientDto> client = new ClientDto();
//        client.setId(CLIENT_ID);
//        client.setUsername("Meta");
//        client.setPassword("12345");
//        client.setEmail("nata@gmail.com");
//        client.setClientDetails(client.getClientDetails());
//        client.setClientAddress(client.getClientAddress());
//
//        System.out.println(client);
//
//        when(clientDao.findById(CLIENT_ID)).thenReturn( Optional.of(client));
//        Optional<ClientDto> result = clientDao.findById(CLIENT_ID);
//
//        assertTrue(result.isPresent());
//        assertEquals(client, result.get());
//    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
       ClientDto clientDto = new ClientDto(CLIENT_ID,
               "nata", "hjhj", "nat@gmail.com", new ClientDetails(
               CLIENT_DETAILS_ID, "Volkova", "Natali", "Nikolaevna",
               LocalDate.of(1984, 8, 31), "KB333333", "566767677", "Minsk",
               LocalDate.of(2022, 12, 12), LocalDate.of( 2030, 01, 01)),
               new ClientAddress(CLIENT_ADDRESS_ID, "Belarus", "Mogilevskay obl", null, "Mogilev", "Pervomayskay",
                       "32", "01", "22-22-22"));
        clientDao.save(clientDto);

        System.out.println(clientDto);

//        when(clientDao.save(clientDto)).thenReturn(clientDto);
//
//        ClientDto savedClientDto = clientDao.save(clientDto);
//        System.out.println(savedClientDto);

        assertNotNull(clientDto);
        assertEquals("nat@gmail.com", clientDto.getEmail());
        assertEquals("nata", clientDto.getUsername());


        verify(clientDao).save(clientDto);
    }
}