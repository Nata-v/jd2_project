package by.nata.service;

import by.nata.data.model.CardDto;
import by.nata.service.model.Card;

public interface CardService {
    void createCard(Card card, String accountNumber);
}
