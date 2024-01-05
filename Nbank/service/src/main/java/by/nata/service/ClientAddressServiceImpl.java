package by.nata.service;

import by.nata.data.dao.BaseDao;
import by.nata.data.dao.ClientAddressDao;


import by.nata.data.entity.Cities;
import by.nata.data.model.ClientAddressDto;

import by.nata.service.model.ClientAddress;
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
                clientAddress.getRegion(),
                clientAddress.getLocality(),
                clientAddress.getCity(),
                clientAddress.getStreet(),
                clientAddress.getHouseNumber(),
                clientAddress.getFlatNumber(),
                clientAddress.getPhoneNumber()
        );
            clientAddressDao.save(clientAddressDto);


    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
