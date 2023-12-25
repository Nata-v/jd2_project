package by.nata.data.dao;

import by.nata.data.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsDao extends JpaRepository<Transactions, String> {


}
