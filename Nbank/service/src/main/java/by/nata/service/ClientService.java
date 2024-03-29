package by.nata.service;


import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    void saveNewClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress);
    boolean delete(String id);
    //Optional<Client> findtById(String id);
    Client findClientById(String id);

   // void updateClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress);
    List<Client> findAllClients();
    Client findByUsername(String username);

}
