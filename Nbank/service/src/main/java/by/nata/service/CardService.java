package by.nata.service;

import by.nata.service.model.Card;

import java.util.List;

public interface CardService {
    void createCard(Card card, String accountNumber);

    Card findCardByCardNumber(String cardNumber);

    void deleteCardByCardNumber(String cardNumber);

    List<Card> getAllCards();
}
