package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.entity.Card;
import by.nata.data.entity.Client;
import by.nata.data.model.AccountDto;
import by.nata.data.model.CardDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public interface CardDao {

    void save(CardDto cardDto, String accountNumber);
    List<CardDto> getAllCards();
    CardDto findByCardNumber(String cardNumber);
    void deleteCardByCardNumber(String cardNumber);

}
