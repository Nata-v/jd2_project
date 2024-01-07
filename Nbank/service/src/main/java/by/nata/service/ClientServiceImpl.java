package by.nata.service;


import by.nata.data.dao.ClientAddressDao;
import by.nata.data.dao.ClientDao;
import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.entity.Role;
import by.nata.data.listener.AccessType;
import by.nata.data.listener.ClientEvent;
import by.nata.data.model.*;

import by.nata.service.model.Client;

import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

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
//
//        ClientDetailsDto clientDetailsDto = new ClientDetailsDto(
//                clientDetails.getId() ,
//                clientDetails.getSurname(),
//                clientDetails.getName(),
//                clientDetails.getBirthDate(),
//                clientDetails.getPassportNumber(),
//                clientDetails.getIdentityNumber(),
//                clientDetails.getDateIssue(),
//                clientDetails.getDateExpiry()
//        );
//
//       ClientAddressDto clientAddressDto = new ClientAddressDto(
//                clientAddress.getId(),
//                clientAddress.getCountry(),
//                clientAddress.getCity(),
//                clientAddress.getStreet(),
//                clientAddress.getHouseNumber(),
//                clientAddress.getFlatNumber(),
//                clientAddress.getPhoneNumber()
//        );
//        ClientDto clientDto = new ClientDto(
//                client.getId() ,
//                client.getUsername(),
//                client.getPassword(),
//                client.getEmail(),
//                Role.USER,
//                clientDetailsDto,
//                clientAddressDto);


        ClientDto clientDto = new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                Role.USER, new ClientDetailsDto(
                        clientDetails.getId(),
                        clientDetails.getSurname(),
                        clientDetails.getName(),
                        clientDetails.getBirthDate(),
                        clientDetails.getPassportNumber(),
                        clientDetails.getIdentityNumber(),
                        clientDetails.getDateIssue(),
                        clientDetails.getDateExpiry()),
                new ClientAddressDto(
                        clientAddress.getId(),
                        clientAddress.getCountry(),
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
                        Role.USER, clientDetailsDto.map(cd ->
                                new ClientDetails(
                                        cd.getId(),
                                        cd.getSurname(),
                                        cd.getName(),
                                        cd.getBirthDate(),
                                        cd.getPassportNumber(),
                                        cd.getIdentityNumber(),
                                        cd.getDateIssue(),
                                        cd.getDateExpiry()
                                )
                        ).orElse(null),
                        clientAddressDto.map(ca ->
                                new ClientAddress(
                                        ca.getId(),
                                        ca.getCountry(),
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
//        var maybeClient = clientDao.findById(id);
//        maybeClient.ifPresent(client -> clientDao.delete(id));
//        return maybeClient.isPresent();
        return clientDao.findById(id).map(clientDto -> {
            clientDao.delete(clientDto.getId());
            return true;
        }).orElse(false);
    }

//    @Override
//    public List<Client> findAllClients() {
////        List<ClientDto> clientsDto = clientDao.findAll();
////
////        List<Client> clients = clientsDto.stream()
////                .map(this::convertToClient)
////                .collect(Collectors.toList());
//
//        return null;//clients;
//    }

//    @Override
//    public List<Client> findByUserName(String username) {
//
//        return  null;
//    }



    @Override
    //@Transactional
    public void updateClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress) {
        ClientDto existingClientDto = clientDao.findById(client.getId()).orElse(null);

        if (existingClientDto != null) {

           // client.setId(existingClientDto.getId());
                    client.setUsername(existingClientDto.getUsername());
            client.setPassword(existingClientDto.getPassword());
            client.setEmail(existingClientDto.getEmail());
           // client.setRole(existingClientDto.getRole());
            client.setClientDetails(clientDetails);
            client.setClientAddress(clientAddress);

            clientDao.update(existingClientDto);

        }
    }





}



