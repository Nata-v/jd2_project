package by.nata.service;


import by.nata.data.dao.ClientDao;
import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import by.nata.service.model.Client;

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
    //@Autowired

    private final ClientDao clientDao;
//private final ClientDetailsDao clientDetailsDao;
private by.nata.service.model.ClientDetails clientDetails;
    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
       // this.clientDetailsDao = clientDetailsDao;
    }

    @Override
    public void saveNewClient(Client client) {
        ClientDetails clientDetails = new ClientDetails();
        ClientDto clientDto = new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
//new by.nata.data.entity.ClientDetails());
        new by.nata.data.entity.ClientDetails(clientDetails.getId(),
                           clientDetails.getSurname(),
            clientDetails.getName(),
            clientDetails.getMiddleName(),
            clientDetails.getBirthDate(),
            clientDetails.getPassportNumber(),
            clientDetails.getIdentityNumber(),
            clientDetails.getCityBirth(),
            clientDetails.getDateIssue(),
            clientDetails.getDateExpiry()));

        client.setClientDetails(clientDetails);
        clientDao.save(clientDto);
    }

    //        String clientDetailsId = client.getClientDetails() != null ? client.getClientDetails().getId() : null;
//        String clientAddressId = client.getClientAddress() != null ? client.getClientAddress().getId() : null;



//    @Override
//    public boolean delete(String id) {
//    var maybeClient = clientDao.findById(id);
//    maybeClient.ifPresent(client -> clientDao.delete(id));
//    return maybeClient.isPresent();
//    }

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



