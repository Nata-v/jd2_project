package by.nata.data.dao;

import by.nata.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientDao extends JpaRepository<Client, String> {
    Client save(Client client);
    Optional<Client>findByUsername(String username);
Client findByEmail(String email);
Client findByAccountNumber(String accountNumber);
Client findByIdentityNumber(String identityNumber);

Client findBySurnameAndFirstnameAndMiddleName(String surname, String name, String middleName);

@Query("UPDATE Client SET surname = :s, name = :n, middleName = :m WHERE id = :id")
    @Modifying
    void updateNameAndSurname(String id, String s, String n, String m);

}
