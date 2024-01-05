package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.entity.*;
import by.nata.data.listener.ClientEvent;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@ContextConfiguration(classes = DataConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDaoImplTest {
//    private static final String CLIENT_ID = "1";
//    private static final String CLIENT_DETAILS_ID = "2";
//    private static final String CLIENT_ADDRESS_ID = "3";

//    @Autowired
//    private ClientDao clientDao;
    //@Mock
    //private SessionFactory sessionFactory;
    //@Mock
    //private Session session;

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

//    @Test
//    public void delete() {
//        ClientDto clientDto = new ClientDto(CLIENT_ID, "username", "password", "email",
//                new ClientDetails("1", "surname", "name", "middleName", null, null, null, null, null, null),
//                new ClientAddress("1", "country", "region", "locality", "city", "street", "houseNumber", "flatNumber", "phoneNumber"));
//
//        System.out.println(clientDto);

        //when(sessionFactory.getCurrentSession()).thenReturn(session);
        //when(session.find(ClientDto.class, CLIENT_ID)).thenReturn(clientDto);
      //  clientDao.delete(CLIENT_ID);
        //session.flush();
        //verify(clientDao).delete(CLIENT_ID);

       // verify(session).flush();

       // verify(session, times(1)).delete(any(ClientDto.class));
        //verify(session, times(1)).flush();
    }


//    @Test
//    public void update() {
//        ClientDto clientDto = new ClientDto(CLIENT_ID, "username", "password", "email",
//                new ClientDetails("1", "surname", "name", "middleName", null, null, null, null, null, null),
//                new ClientAddress("1", "country", "region", "locality", "city", "street", "houseNumber", "flatNumber", "phoneNumber"));
//
//        when(sessionFactory.getCurrentSession()).thenReturn(session);
//        when(session.find(ClientDto.class, CLIENT_ID)).thenReturn(clientDto);
//
//
//        clientDao.update(clientDto);
//
//        assertEquals("1", company.getId());
//        assertEquals("Facebook", company.getName());
//    }

//    @Test
//    public void findById() {
//        ClientDto clientDto = new ClientDto("1", "username", "password", "email",
//                new ClientDetails("1", "surname", "name", "middleName", null, null, null, null, null, null),
//                new ClientAddress("1", "country", "region", "locality", "city", "street", "houseNumber", "flatNumber", "phoneNumber"));
//
//
//        System.out.println(clientDto);
//
//        when(clientDao.findById(CLIENT_ID)).thenReturn( Optional.of(clientDto));
//        Optional<ClientDto> result = clientDao.findById(CLIENT_ID);
//
//        assertTrue(result.isPresent());
//        assertEquals(clientDto, result.get());
//
//        assertEquals("1", result.orElseThrow().getId());
//        assertEquals("username", result.orElseThrow().getUsername());
//        assertEquals("surname", result.orElseThrow().getClientDetails().getSurname());
//        assertEquals("country", result.orElseThrow().getClientAddress().getCountry());
//        verify(clientDao).findById(clientDto.getId());
//    }


//    @Test
//    public void findAll() {
//        List<ClientDto> clients = new ArrayList<>();
//        clients.add(new ClientDto("1", "nata", "12345", "nat@mail.ru", new ClientDetails(), new ClientAddress()));
//        clients.add(new ClientDto("2", "bob", "14444", "bob@mail.ru", new ClientDetails(), new ClientAddress()));
//        clients.add(new ClientDto("3", "star", "47474", "star@mail.ru", new ClientDetails(), new ClientAddress()));
//
//
//        System.out.println(clients);
//        when(clientDao.findAll()).thenReturn(clients);
//
//        List<ClientDto> result = clientDao.findAll();
//        System.out.println(result);
//
//        assertEquals(clients, result);
//
//    }

//    @Test
//    public void save() {
//       ClientDto clientDto = new ClientDto(CLIENT_ID,
//               "nata", "hjhj", "nat@gmail.com", new ClientDetails(
//               CLIENT_DETAILS_ID, "Volkova", "Natali", "Nikolaevna",
//               LocalDate.of(1984, 8, 31), "KB333333", "566767677", "Minsk",
//               LocalDate.of(2022, 12, 12), LocalDate.of( 2030, 01, 01)),
//               new ClientAddress(CLIENT_ADDRESS_ID, "Belarus", "Mogilevskay obl", null, "Mogilev", "Pervomayskay",
//                       "32", "01", "22-22-22"));
//
//       clientDao.save(clientDto);
//
//        System.out.println(clientDto);
//
//
//      //  when(clientDao.save(clientDto)).thenReturn(client);
//
//
//        assertNotNull(clientDto);
//        assertEquals("nat@gmail.com", clientDto.getEmail());
//        assertEquals("nata", clientDto.getUsername());
//
//
//        verify(clientDao).save(clientDto);
//    }
