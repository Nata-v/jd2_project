package by.nata.data.dao;

import by.nata.data.entity.ClientAddress;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ClientAddressDao  {

    String save(ClientAddressDto clientAddressDto);
    Optional<ClientAddressDto> findById(String id);
    void update(ClientAddressDto clientAddressDto);
     List<ClientAddressDto> findAll();

}
