package by.nata.service;

import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientFilterDto;
import by.nata.service.model.ClientDetails;
import by.nata.service.model.ClientFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientDetailsServiceImpl implements ClientDetailsService {

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
                clientDetails.getBirthDate(),
                clientDetails.getPassportNumber(),
                clientDetails.getIdentityNumber(),
                clientDetails.getDateIssue(),
                clientDetails.getDateExpiry()
        );

        clientDetailsDao.save(clientDetailsDto);
    }

    @Override
    public Optional<ClientDetails> findById(String id) {
        Optional<ClientDetailsDto> clientDetailsDto = clientDetailsDao.findById(id);

        return clientDetailsDto.map(this::convertToClientDetails);
    }

    private ClientDetails convertToClientDetails(ClientDetailsDto clientDetailsDto) {
        return new ClientDetails(clientDetailsDto.getId(),
                clientDetailsDto.getSurname(),
                clientDetailsDto.getName(),
                clientDetailsDto.getBirthDate(),
                clientDetailsDto.getPassportNumber(),
                clientDetailsDto.getIdentityNumber(),
                clientDetailsDto.getDateIssue(),
                clientDetailsDto.getDateExpiry());
    }

    @Override
    public List<ClientDetails> findAllByFilter(ClientFilter clientFilter) {

        return clientDetailsDao.findAllByFilter(new ClientFilterDto(clientFilter.getSurname(),
                        clientFilter.getName(),
                        clientFilter.getBirthDate())).
                stream().map(dto -> new ClientDetails(dto.getId(),
                        dto.getSurname(),
                        dto.getName(),
                        dto.getBirthDate(),
                        dto.getPassportNumber(),
                        dto.getIdentityNumber(),
                        dto.getDateIssue(),
                        dto.getDateExpiry())).
                toList();

    }
}
