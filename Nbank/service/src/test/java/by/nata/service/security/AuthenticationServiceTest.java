package by.nata.service.security;

import by.nata.data.dao.ClientDao;
import by.nata.data.entity.Role;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.service.config.ServiceConfigurationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfigurationTest.class)
@TestPropertySource(value = "classpath:some.properties")
public class AuthenticationServiceTest {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private AuthenticationService authenticationService;

    @Test
    public void shouldReturnNotEmptyUserDetails() {

        ClientDto clientDto = new ClientDto("1", "username", "password", "email", Role.USER, new ClientDetailsDto(
                "1", "surname", "name", LocalDate.of(1990, 9, 12), "KB123456", "34343M989787", LocalDate.of(1990, 9, 12), LocalDate.of(1990, 9, 12)),
                new ClientAddressDto("1", "country", "city", "street", "houseNumber", "flatNumber", "phoneNumber"));


        User expectedUser = new User(
                clientDto.getUsername(),
                clientDto.getPassword(),
                Collections.singleton(clientDto.getRole())
        );

        Mockito.when(clientDao.findByUsername(clientDto.getUsername())).thenReturn(clientDto);

        UserDetails actualUser = authenticationService.loadUserByUsername(clientDto.getUsername());
        assertEquals(expectedUser, actualUser);
        Mockito.verify(clientDao, Mockito.times(1)).findByUsername(any());
    }

    @Test
    public void shouldThrowException() {

        ClientDto clientDto = new ClientDto("1", "username", "password", "email", Role.USER, new ClientDetailsDto(
                "1", "surname", "name", LocalDate.of(1990, 9, 12), "KB123456", "34343M989787", LocalDate.of(1990, 9, 12), LocalDate.of(1990, 9, 12)),
                new ClientAddressDto("1", "country", "city", "street", "houseNumber", "flatNumber", "phoneNumber"));

        Mockito.when(clientDao.findByUsername(clientDto.getUsername())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class,
                () -> authenticationService.loadUserByUsername(clientDto.getUsername()));
        Mockito.verify(clientDao, Mockito.times(2)).findByUsername(any());
    }
}