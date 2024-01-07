package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.entity.ClientDetails;
import by.nata.data.model.*;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    void save(ClientDto clientDto);
  void delete(String id);
  Optional<ClientDto> findById(String id);
  void update(ClientDto clientDto);
  List<ClientDto> findAll();
    List<Client> findByUserName(String username);
  List<Client> findAllByFilter(FilterClientDto filterClientDto);
}
