package by.nata.service;

import by.nata.service.model.ClientDetails;

import java.util.Optional;

public interface ClientDetailsService {
    void saveNewClientDetails(ClientDetails clientDetails);
    boolean delete(String id);
    void updateClientDetails(ClientDetails clientDetails);
    void findByNameAndSurnameAndMiddleName(ClientDetails clientDetails);
    Optional<ClientDetails> findById(String id);
}
