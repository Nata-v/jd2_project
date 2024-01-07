package by.nata.service;

import by.nata.data.dao.BaseDao;
import by.nata.data.dao.ClientAddressDao;


import by.nata.data.entity.Cities;
import by.nata.data.model.ClientAddressDto;

import by.nata.data.model.ClientDetailsDto;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientAddressServiceImpl implements ClientAddressService{

    private final ClientAddressDao clientAddressDao;
   // private final BaseDao<String, ClientAddressDto> baseDao;

    @Autowired
    public ClientAddressServiceImpl( ClientAddressDao clientAddressDao) {
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
    public void updateClientAddress(ClientAddress clientAddress) {
        ClientAddressDto existingClientAddressDto = clientAddressDao.findById(clientAddress.getId()).orElse(null);

        if (existingClientAddressDto != null) {
            clientAddress.setCountry(existingClientAddressDto.getCountry());
            clientAddress.setCity(existingClientAddressDto.getCity());
            clientAddress.setStreet(existingClientAddressDto.getStreet());
            clientAddress.setHouseNumber(existingClientAddressDto.getHouseNumber());
            clientAddress.setFlatNumber(existingClientAddressDto.getFlatNumber());
            clientAddress.setPhoneNumber(existingClientAddressDto.getPhoneNumber());

            clientAddressDao.update(existingClientAddressDto);
        }

    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
