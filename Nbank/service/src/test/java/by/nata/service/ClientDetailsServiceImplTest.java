package by.nata.service;

import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.config.ServiceConfigurationTest;
import by.nata.service.model.ClientDetails;
import by.nata.service.model.ClientFilter;
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
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ContextConfiguration(classes = ServiceConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDetailsServiceImplTest {
//    @Autowired
//    private ClientDetailsDao clientDetailsDao;
//    private static final String CLIENT_DETAILS_ID = "2";
//
//    @Autowired
//    private ClientDetailsService clientDetailsService;

//    @Before
//    public void setUp() throws Exception {
//        // MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

//    void  findAllByFilter(){
//        List<ClientDetails> result = clientDetailsService.findAllByFilter();
//        assertThat(result);
//    }


//    @Test
//    public void saveNewClientDetails() {
//        ClientDetails clientDetails = new ClientDetails();
////        ClientDetailsDto clientDetailsDto = new ClientDetailsDto(
////        CLIENT_DETAILS_ID, "Volkova", "Natali", "Nikolaevna",
////                LocalDate.of(2000, 8, 31), "KB333333", "566767677",  "Minsk",
////                LocalDate.of(2022, 12, 12), LocalDate.of(2030, 01, 01));
//
//
//        clientDetails.setId(CLIENT_DETAILS_ID);
//        clientDetails.setName("Natali");
//        clientDetails.setSurname("Volkova");
//        clientDetails.setMiddleName("Nikolaevna");
//        clientDetails.setBirthDate(LocalDate.of(1984, 8, 31));
//        clientDetails.setPassportNumber("KB333333");
//        clientDetails.setIdentityNumber("566767677");
//        clientDetails.setCityBirth("Minsk");
//        clientDetails.setDateIssue(LocalDate.of(2022, 12, 12));
//        clientDetails.setDateExpiry(LocalDate.of(2030, 01, 01));
//
//        ClientDetailsDto clientDetailsDto = new ClientDetailsDto(clientDetails.getId(),
//                clientDetails.getSurname(),
//                clientDetails.getName(),
//                clientDetails.getMiddleName(),
//                clientDetails.getBirthDate(),
//                clientDetails.getPassportNumber(),
//                clientDetails.getIdentityNumber(),
//                clientDetails.getCityBirth(),
//                clientDetails.getDateIssue(),
//                clientDetails.getDateExpiry());
//        assertNotNull(clientDetailsDto);
//        assertEquals("Minsk", clientDetailsDto.getCityBirth());
//        assertEquals("Nikolaevna", clientDetailsDto.getMiddleName());


      //  verify(clientDetailsService).saveNewClientDetails(clientDetails);

//        when(clientDetailsDao.save(clientDetailsDto)).thenReturn(clientDetailsDto);
//
//        Company savedCompany = companyServiceImpl.saveCompany(company);
//        assertEquals(company, savedCompany);
//
//        verify(companyDao, times(1)).save(company);
//
//        assertEquals("Meta", company.getName());


    }

//    @Test
//    public void delete() {
//                ClientDetailsDto clientDetailsDto = new ClientDetailsDto(
//        CLIENT_DETAILS_ID, "Volkova", "Natali", "Nikolaevna",
//                LocalDate.of(2000, 8, 31), "KB333333", "566767677",  "Minsk",
//                LocalDate.of(2022, 12, 12), LocalDate.of(2030, 01, 01));
//        ClientDetails clientDetails = new ClientDetails();
//
//
//        clientDetails.setId(CLIENT_DETAILS_ID);
//        clientDetails.setName("Natali");
//        clientDetails.setSurname("Volkova");
//        clientDetails.setMiddleName("Nikolaevna");
//        clientDetails.setBirthDate(LocalDate.of(1984, 8, 31));
//        clientDetails.setPassportNumber("KB333333");
//        clientDetails.setIdentityNumber("566767677");
//        clientDetails.setCityBirth("Minsk");
//        clientDetails.setDateIssue(LocalDate.of(2022, 12, 12));
//        clientDetails.setDateExpiry(LocalDate.of(2030, 01, 01));
//
//        assertNotNull(clientDetails);

//        assertFalse(clientDetailsService.delete("-12"));
//        assertTrue(clientDetailsService.delete(CLIENT_DETAILS_ID));
   // }
//
//    @Test
//    public void updateClientDetails() {
//    }
//
//    @Test
//    public void findByNameAndSurnameAndMiddleName() {
//    }
