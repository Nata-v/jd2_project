package by.nata.service.security;

import by.nata.data.dao.ClientDao;
import by.nata.data.entity.Role;
import by.nata.data.model.ClientDto;
import by.nata.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

           // List<by.nata.data.entity.Client> appUsers = clientDao.findByUsername(username);

            ClientDto appUser = clientDao.findByUsername(username);
          //  if (appUsers.size() != 1) {
            if (appUser == null){
                throw new UsernameNotFoundException("User not found: " + username);
            }
           // by.nata.data.entity.Client appUser = appUsers.get(0);



            return new User(
                    appUser.getUsername(),
                  appUser.getPassword(),
                  true, true, true,true,
                    List.of(new SimpleGrantedAuthority(appUser.getRole().name()))

            );

        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found: " + username, e);
        }
    }


}
