package by.nata.data.dao;

import by.nata.data.model.CardDto;

import java.util.List;


public interface CardDao {

    void save(CardDto cardDto, String accountNumber);

    List<CardDto> getAllCards();

    CardDto findByCardNumber(String cardNumber);

    CardDto deleteCardByCardNumber(String cardNumber);

}
