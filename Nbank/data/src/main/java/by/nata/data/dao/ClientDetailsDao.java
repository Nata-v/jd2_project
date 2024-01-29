package by.nata.data.dao;

import by.nata.data.entity.ClientDetails;

import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.data.model.ClientFilterDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ClientDetailsDao  {

    String save(ClientDetailsDto clientDetailsDto);

     Optional<ClientDetailsDto> findById(String id);
    List<ClientDetails> findAllByFilter(ClientFilterDto clientFilterDto);


}
