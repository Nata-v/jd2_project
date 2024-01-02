package by.nata.service;

import by.nata.service.model.ClientAddress;

public interface ClientAddressService {

    void saveClientAddress(ClientAddress clientAddress);
    boolean delete(String id);
}
