package by.nata.data.dao;

import by.nata.data.config.DataConfigurationTest;
import by.nata.data.entity.Cities;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.IssuingAuthority;
import by.nata.data.model.ClientDetailsDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ContextConfiguration(classes = DataConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDetailsDaoImplTest {
//@Mock
//private ClientDetailsDao clientDetailsDao;
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void save() {
//
//       ClientDetailsDto clientDetailsDto = new ClientDetailsDto(null, "Volkova", "Natali", "Nikolaevna",
//               LocalDate.of(1984, 8, 31), "KB333333", "566767677", new Cities(null, "Minsk"),
//              LocalDate.of(2022, 12, 12), LocalDate.of( 2030, 01, 01), "Belarus",
//               new IssuingAuthority(null, "Leninskii ROVD"));
//
//
//        System.out.println(clientDetailsDto);
//
//        when(clientDetailsDao.save(clientDetailsDto)).thenReturn(clientDetailsDto);
//
//        ClientDetailsDto savedClientDetailsDto = clientDetailsDao.save(clientDetailsDto);
//        System.out.println(savedClientDetailsDto);
//
//        assertNotNull(savedClientDetailsDto);
//        assertEquals("Natali", savedClientDetailsDto.getName());
//        assertEquals("Minsk", savedClientDetailsDto.getCity().getName());
//
//
//        verify(clientDetailsDao).save(clientDetailsDto);
//    }
//
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
//
//    @Test
//    public void findAll() {
//    }
}