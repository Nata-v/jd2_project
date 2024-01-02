package by.nata.service;


import by.nata.data.dao.ClientAddressDao;
import by.nata.data.dao.ClientDao;
import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.listener.AccessType;
import by.nata.data.listener.ClientEvent;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import by.nata.service.model.Client;

import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService, UserDetailsService {

    private final ClientDao clientDao;
    private final ClientDetailsDao clientDetailsDao;
    private final ClientAddressDao clientAddressDao;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao, ClientDetailsDao clientDetailsDao, ClientAddressDao clientAddressDao, ApplicationEventPublisher applicationEventPublisher) {
        this.clientDao = clientDao;
        this.clientDetailsDao = clientDetailsDao;
        this.clientAddressDao = clientAddressDao;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void saveNewClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress) {
        ClientDto clientDto = new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
        new by.nata.data.entity.ClientDetails(
                clientDetails.getId(),
                clientDetails.getSurname(),
            clientDetails.getName(),
            clientDetails.getMiddleName(),
            clientDetails.getBirthDate(),
            clientDetails.getPassportNumber(),
            clientDetails.getIdentityNumber(),
            clientDetails.getCityBirth(),
            clientDetails.getDateIssue(),
            clientDetails.getDateExpiry()),
                new by.nata.data.entity.ClientAddress(
                        clientAddress.getId(),
                        clientAddress.getCountry(),
                        clientAddress.getRegion(),
                        clientAddress.getLocality(),
                        clientAddress.getCity(),
                        clientAddress.getStreet(),
                        clientAddress.getHouseNumber(),
                        clientAddress.getFlatNumber(),
                        clientAddress.getPhoneNumber()
                ));

       clientDao.save(clientDto);
    }

    //        String clientDetailsId = client.getClientDetails() != null ? client.getClientDetails().getId() : null;
//        String clientAddressId = client.getClientAddress() != null ? client.getClientAddress().getId() : null;


    @Override
    public Optional<Client> findClientById(String id) {

        Optional<ClientDto> clientDto = clientDao.findById(id);
        Optional<ClientDetailsDto> clientDetailsDto = clientDetailsDao.findById(id);
        Optional<ClientAddressDto> clientAddressDto = clientAddressDao.findById(id);

        Optional<Client> result = clientDto.map(dto ->
                new Client(
                        dto.getId(),
                        dto.getUsername(),
                        dto.getPassword(),
                        dto.getEmail(),
                        clientDetailsDto.map(cd ->
                                new ClientDetails(
                                        cd.getId(),
                                        cd.getSurname(),
                                        cd.getName(),
                                        cd.getMiddleName(),
                                        cd.getBirthDate(),
                                        cd.getPassportNumber(),
                                        cd.getIdentityNumber(),
                                        cd.getCityBirth(),
                                        cd.getDateIssue(),
                                        cd.getDateExpiry()
                                )
                        ).orElse(null),
                        clientAddressDto.map(ca ->
                                new ClientAddress(
                                        ca.getId(),
                                        ca.getCountry(),
                                        ca.getRegion(),
                                        ca.getLocality(),
                                        ca.getCity(),
                                        ca.getStreet(),
                                        ca.getHouseNumber(),
                                        ca.getFlatNumber(),
                                        ca.getPhoneNumber()
                                )
                        ).orElse(null)
                )
        );
        result.ifPresent(client ->
                applicationEventPublisher.publishEvent(new ClientEvent(this, AccessType.READ, client.getId())));
return result;

    }

    @Override
    public boolean delete(String id) {
    var maybeClient = clientDao.findById(id);
    maybeClient.ifPresent(client -> clientDao.delete(id));
    return maybeClient.isPresent();
    }



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



