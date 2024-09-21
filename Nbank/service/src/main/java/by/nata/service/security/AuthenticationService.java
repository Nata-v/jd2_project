package by.nata.service.security;

import by.nata.data.dao.ClientDao;
import by.nata.data.model.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings({"unused"})
@Service
public class AuthenticationService implements UserDetailsService {

    private final ClientDao clientDao;

    @Autowired
    public AuthenticationService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            ClientDto appUser = clientDao.findByUsername(username);
            if (appUser == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }


            return new User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority(appUser.getRole().name()))

            );

        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found: " + username, e);
        }
    }


}
