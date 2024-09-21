package by.nata.service;

import by.nata.service.model.ClientAddress;

import java.util.Optional;

public interface ClientAddressService {

    void saveClientAddress(ClientAddress clientAddress);

    Optional<ClientAddress> findById(String id);
}
