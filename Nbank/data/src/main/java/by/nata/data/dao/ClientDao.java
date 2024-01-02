package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    void save(ClientDto clientDto);
  void delete(String id);
  Optional<ClientDto> findById(String id);
  void update(ClientDto clientDto);
  List<ClientDto> findAll();
}
