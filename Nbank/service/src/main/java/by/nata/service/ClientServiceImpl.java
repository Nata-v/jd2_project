package by.nata.service;

import by.nata.data.dao.ClientDao;

import by.nata.data.model.ClientDto;
import by.nata.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

//@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {

    ClientDao clientDao;
    //@Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

//    @Override
//    public void saveNewClient(Client client) {
//        ClientDto dto = new ClientDto(
//                client.getId(),
//                client.getUsername(),
//                client.getPassword(),
//                client.getEmail(),
//                client.getClientDetails(),
//                client.getClientAddress()
//        );
//       clientDao.save(dto);
//
//
//    }


    @Override
    public void saveNewClient(Client client) {

    }

    @Override
    public boolean delete(String id) {
        return clientDao.findById(id)
                .map(entity -> {
            clientDao.delete(entity);
            clientDao.flush();
            return true;
        }).orElse(false);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientDao.findByUsername(username)
                .map(client -> new org.springframework.security.core.userdetails.User(
                        client.getUsername(),
                        client.getPassword(),
                        Collections.singleton(client.getRole())
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));

    }
}



