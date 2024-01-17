package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.entity.Card;
import by.nata.data.entity.Client;
import by.nata.data.model.CardDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public interface CardDao {

    void save(CardDto cardDto, String accountNumber);
    Card getCardById(String cardId);

    Card findByCardNumber(String cardNumber);
}
