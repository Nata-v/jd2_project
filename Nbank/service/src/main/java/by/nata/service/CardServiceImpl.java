package by.nata.service;

import by.nata.data.dao.*;
import by.nata.data.model.AccountDto;
import by.nata.data.model.CardDto;
import by.nata.service.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

@Transactional
@Service
public class CardServiceImpl implements CardService {

    private final AccountDao accountDao;

    private final CardDao cardDao;

    @Autowired
    public CardServiceImpl(AccountDao accountDao, CardDao cardDao) {
        this.accountDao = accountDao;
        this.cardDao = cardDao;
    }


    @Override
    public void createCard(Card card, String accountNumber) {
        String cardNumber = generateCardNumber();
        String cvv = generateCVV();
        ZonedDateTime expireDate = ZonedDateTime.now();
        ZonedDateTime expirationDate = expireDate.plus(3, ChronoUnit.YEARS);
        BigDecimal amount = new BigDecimal("0.0");
        AccountDto accountDto = accountDao.findByAccountNumber(accountNumber);

        if (accountDto == null) {
            throw new RuntimeException("Account number is not found: " + accountNumber);
        }
        CardDto cardDto = new CardDto(
                card.getCardId(),
                accountDto,
                cardNumber,
                amount,
                expirationDate,
                cvv,
                card.getCard_status(),
                card.getCurrency());

        cardDao.save(cardDto, accountDto.getAccountNumber());


    }

    private String generateCardNumber() {
        String cardNumber;
        do {
            cardNumber = UUID.randomUUID().toString().replaceAll("-", "")
                    .substring(0, 16);
        } while (cardDao.findByCardNumber(cardNumber) != null);
        return cardNumber;
    }


    public static String generateCVV() {
        Random random = new Random();
        int cvvNumber = random.nextInt(900) + 100;

        return String.format("%03d", cvvNumber);
    }
}
