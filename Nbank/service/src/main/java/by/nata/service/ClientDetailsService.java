package by.nata.service;

import by.nata.service.model.ClientDetails;

public interface ClientDetailsService {
    void saveNewClientDetails(ClientDetails clientDetails);
    boolean delete(String id);
    void updateClientDetails(ClientDetails clientDetails);
    void findByNameAndSurnameAndMiddleName(ClientDetails clientDetails);
}
