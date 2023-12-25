package by.nata.service;


import by.nata.service.model.Client;

public interface ClientService {
    void saveNewClient(Client client);
    boolean delete(String id);
}
