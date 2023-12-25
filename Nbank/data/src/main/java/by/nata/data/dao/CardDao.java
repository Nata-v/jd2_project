package by.nata.data.dao;

import by.nata.data.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao extends JpaRepository<Card, String> {


}
