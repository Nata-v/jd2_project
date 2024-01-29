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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientDao clientDao;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao, ApplicationEventPublisher applicationEventPublisher) {
        this.clientDao = clientDao;

        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override

    public void saveNewClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress) {


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

    @Override
    public Client findClientById(String id) {
        ClientDto clientDto = clientDao.getClientById(id);
        if (clientDto != null) {
            return convertToModel(clientDto);
        }
        return null;
    }
//    @Override
//    public Optional<Client> findClientById(String id) {
//        return clientDao.getClientById(id)
//                .map(this::convertToModel);
//    }


//        result.ifPresent(client ->
//                applicationEventPublisher.publishEvent(new ClientEvent(this, AccessType.READ, client.getId())));


    @Override
    public boolean delete(String id) {
        ClientDto client = clientDao.getClientById(id);
        if (client != null) {
            clientDao.deleteClientById(client.getId());
            return true;
        }
        return false;
    }

//    @Override
//    public boolean delete(String id) {
//        Optional<ClientDto> clientOptional = clientDao.findById(id);
//
//        if (clientOptional.isPresent()) {
//            ClientDto clientDto = clientOptional.get();
//            clientDao.delete(clientDto.getId());
//
//            return true;
//        }
//
//        return false;
//    }

    @Override
    public List<Client> findAllClients() {
        List<ClientDto> clientsDto = clientDao.findAll();

        List<Client> clients = clientsDto.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());

        return clients;
    }


    @Override
    public Client findByUsername(String username) {

        ClientDto clientDto = clientDao.findByUsername(username );
        if (clientDto != null) {
            return convertToModel(clientDto);
        }

        return null;
    }

    private Client convertToModel(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getUsername(),
                clientDto.getPassword(),
                clientDto.getEmail(),
                clientDto.getRole(),
          convertToModelDetails(clientDto.getClientDetailsDto()),
                convertToModelAddress(clientDto.getClientAddressDto()));



    }


    private ClientDetails convertToModelDetails(ClientDetailsDto clientDetailsDto) {
        return new ClientDetails(clientDetailsDto.getId(),
                clientDetailsDto.getSurname(),
                clientDetailsDto.getName(),
                clientDetailsDto.getBirthDate(),
                clientDetailsDto.getPassportNumber(),
                clientDetailsDto.getIdentityNumber(),
                clientDetailsDto.getDateIssue(),
                clientDetailsDto.getDateExpiry());
    }

    private ClientAddress convertToModelAddress(ClientAddressDto clientAddressDto) {
        return new ClientAddress(clientAddressDto.getId(),
                clientAddressDto.getCountry(),
                clientAddressDto.getCity(),
                clientAddressDto.getStreet(),
                clientAddressDto.getHouseNumber(),
                clientAddressDto.getFlatNumber(),
                clientAddressDto.getPhoneNumber());
    }


    private ClientDto mapToClientDto(Client client, ClientDetails clientDetails,
                                     ClientAddress clientAddress) {

        return new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole(),
                new ClientDetailsDto(
                        clientDetails.getId(),
                        clientDetails.getSurname(),
                        clientDetails.getName(),
                        clientDetails.getBirthDate(),
                        clientDetails.getPassportNumber(),
                        clientDetails.getIdentityNumber(),
                        clientDetails.getDateIssue(),
                        clientDetails.getDateExpiry()),
                new ClientAddressDto(clientAddress.getId(),
                        clientAddress.getCountry(),
                        clientAddress.getCity(),
                        clientAddress.getStreet(),
                        clientAddress.getHouseNumber(),
                        clientAddress.getFlatNumber(),
                        clientAddress.getPhoneNumber()));

       // return clientDto;
    }
//    @Override
//    @Transactional
//    public void updateClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress) {
//        ClientDto existingClientDto = clientDao.findById(client.getId()).orElse(null);
//        ClientDetailsDto existingClientDetailsDto = clientDetailsDao.findById(clientDetails.getId()).orElse(null);
//        ClientAddressDto existingClientAddressDto = clientAddressDao.findById(clientAddress.getId()).orElse(null);
//
//        if (existingClientDto != null && existingClientDetailsDto != null && existingClientAddressDto != null) {
//
//           // client.setId(existingClientDto.getId());
//                    client.setUsername(existingClientDto.getUsername());
//            client.setPassword(existingClientDto.getPassword());
//            client.setEmail(existingClientDto.getEmail());
//           // client.setRole(existingClientDto.getRole());
//            client.setClientDetails(clientDetails);
//            client.setClientAddress(clientAddress);
//
////            clientDetailsDao.update(existingClientDetailsDto);
////            clientAddressDao.update(existingClientAddressDto);
//            clientDao.update(existingClientDto, existingClientDetailsDto, existingClientAddressDto);
//
//
//        }
//    }


}



