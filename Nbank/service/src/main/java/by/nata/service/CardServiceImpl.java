package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.CardDao;
import by.nata.data.model.AccountDto;
import by.nata.data.model.CardDto;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.service.model.Card;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class CardServiceImpl implements CardService {
    private static final Logger log = LoggerFactory.getLogger(CardServiceImpl.class);
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

    @Override
    @Transactional(readOnly = true)
    public List<Card> getAllCards() {
        List<CardDto> cardDto = cardDao.getAllCards();

        List<Card> cards = cardDto.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());

        return cards;
    }

    @Override
    @Transactional(readOnly = true)
    public Card findCardByCardNumber(String cardNumber) {
        CardDto cardDto = cardDao.findByCardNumber(cardNumber);
        if (cardDto != null) {
            return convertToModel(cardDto);
        }
        return null;
    }

    private Card convertToModel(CardDto cardDto) {
        return new Card(
                cardDto.getCardId(),
                convertToModel(cardDto.getAccountDto()),
                cardDto.getCardNumber(),
                cardDto.getBalance(),
                cardDto.getExpiryDate(),
                cardDto.getCvv(),
                cardDto.getCard_status(),
                cardDto.getCurrency()
        );
    }

    private by.nata.service.model.Account convertToModel(AccountDto accountDto) {
        return new by.nata.service.model.Account(
                accountDto.getAccountId(),
                convertToModel(accountDto.getClientDto()),
                accountDto.getAccountNumber(),
                accountDto.getDateOpen(),
                accountDto.getBalance(),
                accountDto.getCurrency(),
                accountDto.getPin()
        );
    }

    private Client convertToModel(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getUsername(),
                clientDto.getPassword(),
                clientDto.getEmail(),
                clientDto.getRole(),
                convertToModelDetails(clientDto.getClientDetailsDto()),
                convertToModelAddress(clientDto.getClientAddressDto()));


    }


    private ClientDetails convertToModelDetails(ClientDetailsDto clientDetailsDto) {
        return new ClientDetails(clientDetailsDto.getId(),
                clientDetailsDto.getSurname(),
                clientDetailsDto.getName(),
                clientDetailsDto.getBirthDate(),
                clientDetailsDto.getPassportNumber(),
                clientDetailsDto.getIdentityNumber(),
                clientDetailsDto.getDateIssue(),
                clientDetailsDto.getDateExpiry());
    }

    private ClientAddress convertToModelAddress(ClientAddressDto clientAddressDto) {
        return new ClientAddress(clientAddressDto.getId(),
                clientAddressDto.getCountry(),
                clientAddressDto.getCity(),
                clientAddressDto.getStreet(),
                clientAddressDto.getHouseNumber(),
                clientAddressDto.getFlatNumber(),
                clientAddressDto.getPhoneNumber());
    }

    @Override
    public void deleteCardByCardNumber(String cardNumber) {
        CardDto cardDto = cardDao.findByCardNumber(cardNumber);

        if (cardDto != null) {
            cardDao.deleteCardByCardNumber(cardNumber);
        }
        log.error("Card number not found!");
    }
}
