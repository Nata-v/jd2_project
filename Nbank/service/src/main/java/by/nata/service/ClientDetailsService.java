package by.nata.service;

import by.nata.service.model.ClientDetails;
import by.nata.service.model.ClientFilter;

import java.util.List;
import java.util.Optional;

public interface ClientDetailsService {
    void saveNewClientDetails(ClientDetails clientDetails);
    boolean delete(String id);
    void updateClientDetails(ClientDetails clientDetails);
    List<ClientDetails> findAllByFilter(ClientFilter clientFilter);
    Optional<ClientDetails> findById(String id);
}
