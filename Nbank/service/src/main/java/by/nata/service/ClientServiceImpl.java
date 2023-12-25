package by.nata.service;


import by.nata.data.dao.ClientDao;
import by.nata.data.model.ClientDto;
import by.nata.data.entity.ClientDetails;
import by.nata.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService, UserDetailsService {

    private final ClientDao clientDao;
    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }






    @Override
    public void saveNewClient(Client client) {
        ClientDto dto = new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole()
        );
     // clientDao.save(dto);


    }


//    @Override
//    public void saveNewClient(Client client) {
//
//    }

    @Override
    public boolean delete(String id) {
    var maybeClient = clientDao.findById(id);
    maybeClient.ifPresent(client -> clientDao.delete(id));
    return maybeClient.isPresent();
    }

//    public Optional<Client> findClientById(String id){
//        return clientDao.findById(id).map();
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return clientDao.findByUsername(username)
//                .map(client -> new org.springframework.security.core.userdetails.User(
//                        client.getUsername(),
//                        client.getPassword(),
//                        Collections.singleton(client.getRole())
//                ))
//                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));
//
//    }
}



