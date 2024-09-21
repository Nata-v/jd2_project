package by.nata.data.dao;

import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import java.util.List;

public interface ClientDao {
    String save(ClientDto clientDto);

    ClientDto getClientById(String id);

    ClientDto deleteClientById(String id);

    void update(ClientDto clientDto, ClientDetailsDto clientDetailsDto, ClientAddressDto clientAddressDto);

    List<ClientDto> findAll();

    ClientDto findByUsername(String username);


}
