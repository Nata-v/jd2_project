package by.nata.service;


import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;

import java.util.List;

public interface ClientService {
    void saveNewClient(Client client, ClientDetails clientDetails, ClientAddress clientAddress);

    boolean delete(String id);

    Client findClientById(String id);

    List<Client> findAllClients();

    Client findByUsername(String username);

}
