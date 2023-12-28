package by.nata.service;


import by.nata.data.dao.ClientDao;
import by.nata.data.model.ClientDto;

import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;

import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService, UserDetailsService {

    private final ClientDao clientDao;
    private final ClientDetails clientDetails;
    private final ClientAddress clientAddress;
    private final Client client;

    public ClientServiceImpl(@Autowired ClientDao clientDao, ClientDetails clientDetails, ClientAddress clientAddress, Client client) {
        this.clientDao = clientDao;
        this.clientDetails = clientDetails;
        this.clientAddress = clientAddress;
        this.client = client;
    }

    @Override
    public void saveNewClient(Client client) {
        String clientDetailsId = client.getClientDetails() != null ? client.getClientDetails().getId() : null;
        String clientAddressId = client.getClientAddress() != null ? client.getClientAddress().getId() : null;

        ClientDto clientDto = new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole(),
               // clientDetailsId,
               // clientAddressId
                new by.nata.data.entity.ClientDetails(),
                new by.nata.data.entity.ClientAddress()
        );
      clientDao.save(clientDto);


    }


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



