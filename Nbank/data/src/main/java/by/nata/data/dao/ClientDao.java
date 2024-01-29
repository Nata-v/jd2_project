package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.entity.ClientAddress;
import by.nata.data.entity.ClientDetails;
import by.nata.data.model.*;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    String save(ClientDto clientDto);
  ClientDto getClientById(String id);
  ClientDto deleteClientById(String id);

 // Optional<ClientDto> findById(String id);
  void update(ClientDto clientDto, ClientDetailsDto clientDetailsDto, ClientAddressDto clientAddressDto);
  List<ClientDto> findAll();
  ClientDto findByUsername(String username);


}
