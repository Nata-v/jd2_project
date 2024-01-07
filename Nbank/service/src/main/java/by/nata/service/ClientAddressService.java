package by.nata.service;

import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;

public interface ClientAddressService {

    void saveClientAddress(ClientAddress clientAddress);
    boolean delete(String id);
    void updateClientAddress(ClientAddress clientAddress);
}
