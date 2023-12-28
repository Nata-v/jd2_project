package by.nata.service;

import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.entity.Cities;
import by.nata.data.entity.IssuingAuthority;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
                new Cities(),
                clientDetails.getDateIssue(),
                clientDetails.getDateExpiry(),
                clientDetails.getNationality(),
               new IssuingAuthority()
        );

        clientDetailsDao.save(clientDetailsDto);
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
