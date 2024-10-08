package by.nata.data.dao;

import by.nata.data.entity.ClientAddress;
import by.nata.data.model.ClientAddressDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class ClientAddressDaoImpl implements ClientAddressDao {
    private static final Logger log = LoggerFactory.getLogger(ClientAddressDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public ClientAddressDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String save(ClientAddressDto clientAddressDto) {

        final Session session = sessionFactory.getCurrentSession();
        ClientAddress clientAddress = new ClientAddress(
                clientAddressDto.getId(),
                clientAddressDto.getCountry(),
                clientAddressDto.getCity(),
                clientAddressDto.getStreet(),
                clientAddressDto.getHouseNumber(),
                clientAddressDto.getFlatNumber(),
                clientAddressDto.getPhoneNumber()
        );

        return (String) session.save(clientAddress);

    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ClientAddressDto> findById(String id) {

        final Session session = sessionFactory.getCurrentSession();

        ClientAddress clientAddress = session.find(ClientAddress.class, id);
        return Optional.of(new ClientAddressDto(clientAddress.getId(),
                clientAddress.getCountry(),
                clientAddress.getCity(),
                clientAddress.getStreet(),
                clientAddress.getHouseNumber(),
                clientAddress.getFlatNumber(),
                clientAddress.getPhoneNumber()));
    }

}
