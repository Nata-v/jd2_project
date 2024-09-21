package by.nata.data.dao;

import by.nata.data.model.ClientAddressDto;

import java.util.Optional;


public interface ClientAddressDao {

    String save(ClientAddressDto clientAddressDto);

    Optional<ClientAddressDto> findById(String id);

}
