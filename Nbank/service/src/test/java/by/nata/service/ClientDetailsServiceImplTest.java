package by.nata.service;

import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.entity.Cities;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.IssuingAuthority;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.config.ServiceConfigurationTest;

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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@ContextConfiguration(classes = ServiceConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDetailsServiceImplTest {
//    @Mock
//    private ClientDetailsDao clientDetailsDao;
//
//    @InjectMocks
//    //@Autowired
//    private ClientDetailsServiceImpl clientDetailsServiceImpl;
//    private static final String COMPANY_ID = "1";
//    @Autowired
//    ClientDetailsService clientDetailsService;
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void saveNewClientDetails() {
//ClientDetails clientDetails = new ClientDetails();
     //   ClientDetailsDto clientDetailsDto = new ClientDetailsDto();
//
//
//        clientDetails.setId(COMPANY_ID),
//        clientDetails.setName("Natali"),
//        clientDetails.setSurname("Volkova"),
//        clientDetails.setMiddleName("Nikolaevna"),
//        clientDetails.setBirthDate(LocalDate.of(1984, 8,31)),
//    clientDetails.setPassportNumber("KB333333"),
//    clientDetails.setIdentityNumber("566767677"),
//    clientDetails.getCity().getId(),
//    clientDetails.setDateIssue( LocalDate.of(2022, 12, 12)),
//    clientDetails.setDateExpiry(LocalDate.of( 2030, 01, 01)),
//    clientDetails.setNationality("Belarus"),
//    clientDetails.getIssuingAuthority().getId());

       // when(clientDetailsDao.save(clientDetailsDto)).thenReturn(clientDetailsDto);

//        Company savedCompany = companyServiceImpl.saveCompany(company);
//        assertEquals(company, savedCompany);
//
//        verify(companyDao, times(1)).save(company);
//
//        assertEquals("Meta", company.getName());

        //        ClientDetails clientDetails = new ClientDetails(null,"Volkova", "Natali", "Nikolaevna",
//                LocalDate.of(1984, 8, 31), "KB333333", "566767677", new Cities(null, "Minsk"),
//                LocalDate.of(2022, 12, 12), LocalDate.of( 2030, 01, 01), "Belarus",
//                new IssuingAuthority(null, "Leninskii ROVD"));
  //  }

//    @Test
//    public void delete() {
//    }
//
//    @Test
//    public void updateClientDetails() {
//    }
//
//    @Test
//    public void findByNameAndSurnameAndMiddleName() {
//    }
}