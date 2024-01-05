package by.nata.service;

import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientFilterDto;
import by.nata.service.model.ClientDetails;
import by.nata.service.model.ClientFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
//
//        return clientDetailsDao.findById(id);
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) {


    }
//    public List<ProductSpecification> searchProducts(SearchCriteria searchCriteria)throws SQLException,ClassNotFoundException {
//
//        return   productSpecificationDao
//                .read()
//                .stream()
//                .map(dto -> new ProductSpecification(dto.getProductName(),
//                        dto.getProductPrice(), dto.getId()))
//                .filter(productSpecification ->
//                        productSpecification.getProductName()
//                                .contains(searchCriteria.getProductNameCriteria()))
//                .toList();

    @Override
    public List<ClientDetails> findAllByFilter(ClientFilter clientFilter) {
    return clientDetailsDao.findAllByFilter(new ClientFilterDto(clientFilter.getSurname(),
                    clientFilter.getName(),
                    clientFilter.getMiddleName(),
                    clientFilter.getBirthDate())).
            stream().map(dto -> new ClientDetails(dto.getId(),
                    dto.getSurname(),
                    dto.getName(),
                    dto.getMiddleName(),
                   dto.getBirthDate(),
                    dto.getPassportNumber(),
                    dto.getIdentityNumber(),
                    dto.getCityBirth(),
                    dto.getDateIssue(),
                    dto.getDateExpiry())).
                    toList();

    }
}
