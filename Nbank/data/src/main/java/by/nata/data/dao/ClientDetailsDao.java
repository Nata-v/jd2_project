package by.nata.data.dao;

import by.nata.data.entity.ClientDetails;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientFilterDto;

import java.util.List;
import java.util.Optional;


public interface ClientDetailsDao  {

    String save(ClientDetailsDto clientDetailsDto);

     Optional<ClientDetailsDto> findById(String id);
    List<ClientDetails> findAllByFilter(ClientFilterDto clientFilterDto);


}
