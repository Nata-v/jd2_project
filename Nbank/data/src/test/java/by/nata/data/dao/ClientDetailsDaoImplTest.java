package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.entity.ClientDetails;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientFilterDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

//@ContextConfiguration(classes = DataConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDetailsDaoImplTest {

//     @Autowired
//private ClientDetailsDao clientDetailsDao;

//    @Before
//    public void setUp() throws Exception {
//      // MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

//    @Test
//    public void save() {
//
//       ClientDetailsDto clientDetailsDto = new ClientDetailsDto(null, "Volkova", "Natali",
//               LocalDate.of(2000, 8, 31), "KB333333", "566767677",
//              LocalDate.of(2022, 12, 12), LocalDate.of( 2030, 01, 01));
//
//
//        System.out.println(clientDetailsDto);
//
//       clientDetailsDao.save(clientDetailsDto);
//
//        assertNotNull(clientDetailsDto);
//        assertEquals("Natali", clientDetailsDto.getName());
//        assertEquals(LocalDate.of(2000, 8, 31), clientDetailsDto.getBirthDate());
//
//    }



//    @Test
//    public void delete() {
//    }
//
//    @Test
//    public void update() {
//    }

//    @Test
//    public void findById() {
//
//                ClientDetailsDto clientDetailsDto = new ClientDetailsDto(
//                "clientId", "Volkova", "Natali",
//                LocalDate.of(2000, 8, 31),
//                        "KB333333", "566767677",
//                LocalDate.of(2022, 12, 12), LocalDate.of(2030, 01, 01));
//
//        clientDetailsDao.save(clientDetailsDto);
//
//
//        Optional<ClientDetailsDto> result = clientDetailsDao.findById("testId");
//        assertTrue(result.isPresent());
//
//        assertEquals("clientId", result.map(ClientDetailsDto::getId).orElse(null));
//        assertEquals("Volkova", result.map(ClientDetailsDto::getSurname).orElse(null));
//        assertEquals("Natali", result.map(ClientDetailsDto::getName).orElse(null));
//       // assertEquals(LocalDate.of(1990, 1, 1), result.map(ClientDetailsDto::getBirthDate).orElse(null));
//
//    }

//    @Test
//    public void findAllByFilter() {
//
//        ClientFilterDto clientFilterDto = new ClientFilterDto("TestSurname", "TestName",
//                LocalDate.of(1990, 1, 1));
//
//        List<ClientFilterDto> clientDetailsDtoList = new ArrayList<>();
//        clientDetailsDtoList.add(clientFilterDto);
//        //when(query.getResultList()).thenReturn(clientDetailsDtoList);
//
//        List<ClientDetails> result = clientDetailsDao.findAllByFilter(clientFilterDto);
//
//        assertEquals(clientDetailsDtoList, result);
//    }
}