package by.nata.service;

import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClientDetailsServiceImpl implements ClientDetailsService{

    private final ClientDetailsDao clientDetailsDao;
@Autowired
    public ClientDetailsServiceImpl(ClientDetailsDao clientDetailsDao) {
        this.clientDetailsDao = clientDetailsDao;
    }

    @Override
    public void saveNewClientDetails(ClientDetails clientDetails) {


       ClientDetailsDto clientDetailsDto = new ClientDetailsDto(
                clientDetails.getId(),
                clientDetails.getSurname(),
                clientDetails.getName(),
                clientDetails.getMiddleName(),
                clientDetails.getBirthDate(),
                clientDetails.getPassportNumber(),
                clientDetails.getIdentityNumber(),
                clientDetails.getCityBirth(),
                clientDetails.getDateIssue(),
                clientDetails.getDateExpiry()
        );

        clientDetailsDao.save(clientDetailsDto);
    }

    @Override
    public Optional<ClientDetails> findById(String id) {
//        Optional<ClientDetailsDto> clientDetailsDto = clientDetailsDao.findById(id);
//        return new ClientDetails(clientDetailsDto.get(id);

        //return clientDetailsDao.findById(id);
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) {

    }

    @Override
    public void findByNameAndSurnameAndMiddleName(ClientDetails clientDetails) {

    }
}
