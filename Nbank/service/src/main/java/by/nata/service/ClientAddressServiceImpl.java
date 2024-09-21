package by.nata.service;

import by.nata.data.dao.ClientAddressDao;
import by.nata.data.model.ClientAddressDto;
import by.nata.service.model.ClientAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClientAddressServiceImpl implements ClientAddressService {

    private final ClientAddressDao clientAddressDao;

    @Autowired
    public ClientAddressServiceImpl(ClientAddressDao clientAddressDao) {
        this.clientAddressDao = clientAddressDao;
    }

    @Override
    public void saveClientAddress(ClientAddress clientAddress) {
        ClientAddressDto clientAddressDto = new ClientAddressDto(
                clientAddress.getId(),
                clientAddress.getCountry(),
                clientAddress.getCity(),
                clientAddress.getStreet(),
                clientAddress.getHouseNumber(),
                clientAddress.getFlatNumber(),
                clientAddress.getPhoneNumber()
        );
        clientAddressDao.save(clientAddressDto);


    }

    @Override
    public Optional<ClientAddress> findById(String id) {
        Optional<ClientAddressDto> clientAddressDto = clientAddressDao.findById(id);

        return clientAddressDto.map(this::convertToClientAddress);
    }

    private ClientAddress convertToClientAddress(ClientAddressDto clientAddressDto) {
        return new ClientAddress(clientAddressDto.getId(),
                clientAddressDto.getCountry(),
                clientAddressDto.getCity(),
                clientAddressDto.getStreet(),
                clientAddressDto.getHouseNumber(),
                clientAddressDto.getFlatNumber(),
                clientAddressDto.getPhoneNumber());
    }


}
