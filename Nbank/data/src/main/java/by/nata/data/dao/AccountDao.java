package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, String> {
    Optional<Account> findByAccountNumber(String accountNumber);
    @Query("UPDATE Account SET client = :client WHERE id = :accountId")
    @Modifying
    void updateAccountSetClient(Client client, String accountId);

    @Query("UPDATE Account SET balance = :balance WHERE id = :accountId")
    @Modifying
    void updateAccountSetBalance(String accountId, BigDecimal balance);
}
