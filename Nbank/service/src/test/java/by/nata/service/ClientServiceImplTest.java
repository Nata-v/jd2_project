package by.nata.service;

import by.nata.data.dao.ClientDao;
import by.nata.data.listener.ClientEvent;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.service.config.ServiceConfigurationTest;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ContextConfiguration(classes = ServiceConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceImplTest {
//    private static final String CLIENT_ID = "1";
//    private static final String CLIENT_DETAILS_ID = "2";
//    private static final String CLIENT_ADDRESS_ID = "3";
//    @Mock
//    private ClientDao clientDao;
//    @Mock
//    private ApplicationEventPublisher eventPublisher;

//    @InjectMocks
//    @Mock
//    private ClientService clientService;
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
//    public void saveNewClient() {
//
//
//    }

//    @Test
//    public void findAllClientsTest(){
//        List<Client> result = clientService.findAllClients();
//       // assertThat(result).;
//
//
//    }

//    @Test
//    public void findClientById() {
//
//        Optional<Client> findClient =clientService.findClientById(CLIENT_ID);
//
//    }
//        Mockito.doReturn(Optional.of(new Client(CLIENT_ID,
//                       "nata",
//                "12345",
//                "nata@gmail.com",
//                new ClientDetails(CLIENT_DETAILS_ID,
//                        "Volkova",
//                        "Natali",
//                        "Nikolaevna",
//                        LocalDate.of(2000, 8, 31),
//                        "KB232323",
//                        "1235M0987",
//                        "Mogilev",
//                        LocalDate.of(2020,10,10),
//                        LocalDate.of(2025,10,10)),
//                new ClientAddress(CLIENT_ADDRESS_ID,
//                        "Belarus",
//                        "Minskaya obl",
//                        null,
//                        "Minsk",
//                        "Nemiga",
//                        "6",
//                        "15",
//                        "25-45-55"
//                        )
//                        )))
//
//                .when(clientDao).findById(CLIENT_ID);
//
//        var actualResult = clientService.findClientById(CLIENT_ID);
//        System.out.println(actualResult);
//        assertTrue(actualResult.isPresent());
//
//        var expectedResult = Optional.of(new Client(CLIENT_ID,
//                "nata",
//                "12345",
//                "nata@gmail.com",
//                new ClientDetails(CLIENT_DETAILS_ID,
//                        "Volkova",
//                        "Natali",
//                        "Nikolaevna",
//                        LocalDate.of(2000, 8, 31),
//                        "KB232323",
//                        "1235M0987",
//                        "Mogilev",
//                        LocalDate.of(2020,10,10),
//                        LocalDate.of(2025,10,10)),
//                new ClientAddress(
//                        CLIENT_ADDRESS_ID,
//                        "Belarus",
//                        "Minskaya obl",
//                        null,
//                        "Minsk",
//                        "Nemiga",
//                        "6",
//                        "15",
//                        "25-45-55"
//                )));
//        System.out.println(expectedResult);
//       // actualResult.isPresent(actual -> assertEquals(expectedResult, actual));
//         assertEquals(expectedResult, actualResult);
//        verify(eventPublisher).publishEvent(any(ClientEvent.class));






    // Предполагаемые значения из базы данных
//    ClientDto clientDto = new ClientDto("1", "username", "password", "email");
//    ClientDetailsDto clientDetailsDto = new ClientDetailsDto("1", "surname", "name", "middleName", null, null, null, null, null, null);
//    ClientAddressDto clientAddressDto = new ClientAddressDto("1", "country", "region", "locality", "city", "street", "houseNumber", "flatNumber", "phoneNumber");
//
//    // Задаем поведение моков для методов findById
//    when(clientDao.findById("1")).thenReturn(Optional.of(clientDto));
//    when(clientDetailsDao.findById("1")).thenReturn(Optional.of(clientDetailsDto));
//    when(clientAddressDao.findById("1")).thenReturn(Optional.of(clientAddressDto));
//
//    // Вызываем тестируемый метод
//    Optional<Client> result = clientService.findClientById("1");
//
//    // Проверяем, что результат не пустой и содержит ожидаемые значения
//    assertEquals("1", result.orElseThrow().getId());
//    assertEquals("username", result.orElseThrow().getUsername());
//    assertEquals("surname", result.orElseThrow().getClientDetails().getSurname());
//    assertEquals("country", result.orElseThrow().getClientAddress().getCountry());
//
//    // Проверяем, что событие было опубликовано
//    verify(applicationEventPublisher, times(1)).publishEvent(any(ClientEvent.class));
//}
//    }

//    @Test
//    public void delete() {
//        assertFalse(clientService.delete("-12"));
//        assertTrue(clientService.delete(CLIENT_ID));
//    }

    @Test
    public void loadUserByUsername() {
    }
}