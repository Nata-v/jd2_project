package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.entity.Cities;
import by.nata.data.entity.ClientDetails;
import by.nata.data.model.ClientDetailsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@ContextConfiguration(classes = DataConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDetailsDaoImplTest {
//@Mock
    // @Autowired
//    @Mock
//private ClientDetailsDao clientDetailsDao;
//    @Mock
//    private SessionFactory sessionFactory;
//
//    @Mock
//    private Session session;
//
//    @Before
//    public void setUp() throws Exception {
//       MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

//    @Test
//    public void save() {
//
//       ClientDetailsDto clientDetailsDto = new ClientDetailsDto(null, "Volkova", "Natali", "Nikolaevna",
//               LocalDate.of(2000, 8, 31), "KB333333", "566767677", "Minsk",
//              LocalDate.of(2022, 12, 12), LocalDate.of( 2030, 01, 01));
//
//
//        System.out.println(clientDetailsDto);
//
//        //when(clientDetailsDao.save(any(ClientDetailsDto.class))).thenReturn(clientDetailsDto);
//
//           clientDetailsDao.save(clientDetailsDto);
//
//        assertNotNull(clientDetailsDto);
//        assertEquals("Natali", clientDetailsDto.getName());
//        assertEquals(LocalDate.of(2000, 8, 31), clientDetailsDto.getBirthDate());
//
//        verify(clientDetailsDao).save(clientDetailsDto);
//    }
//    @Test
//    public void findById(){
//
//        String clientId = "111";
//        ClientDetailsDto expectedClientDetailsDto = new ClientDetailsDto(
//                clientId, "Volkova", "Natali", "Nikolaevna",
//                LocalDate.of(2000, 8, 31), "KB333333", "566767677", "Minsk",
//                LocalDate.of(2022, 12, 12), LocalDate.of(2030, 01, 01));
//        clientDetailsDao.save(expectedClientDetailsDto);
//
//        System.out.println(expectedClientDetailsDto);
//        when(sessionFactory.getCurrentSession()).thenReturn(session);
//        when(session.find(eq(ClientDetailsDto.class), eq(clientId))).thenReturn(expectedClientDetailsDto);
//
//        Optional<ClientDetailsDto> result = clientDetailsDao.findById(clientId);
//        System.out.println(result);
//        assertTrue(result.isPresent());
//        assertEquals(expectedClientDetailsDto, result.get());
//    }




//    @Test
//    public void delete() {
//    }
//
//    @Test
//    public void update() {
//    }
//
//    @Test
//    public void findById() {
//    }

//    @Test
//    public void findAll() {
//    }
}