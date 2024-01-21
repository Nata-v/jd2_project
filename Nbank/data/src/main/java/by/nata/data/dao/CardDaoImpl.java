package by.nata.data.dao;

import by.nata.data.entity.*;
import by.nata.data.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CardDaoImpl implements CardDao{
    private static final Logger log = LoggerFactory.getLogger(CardDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public CardDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public void save(CardDto cardDto, String accountNumber){
        final Session session = sessionFactory.getCurrentSession();

        String hql = "from Account WHERE accountNumber = :accountNumber";
        Query<Account> query = session.createQuery(hql, Account.class);
        query.setParameter("accountNumber", accountNumber);
        Account account = query.uniqueResult();
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber     );
        }
        Card card = new Card();
        card.setCardId(cardDto.getCardId());
        card.setAccountId(account);
        card.setCardNumber(cardDto.getCardNumber());
        card.setBalance(cardDto.getBalance());
        card.setExpiryDate(cardDto.getExpiryDate());
        card.setCvv(cardDto.getCvv());
        card.setCard_status(cardDto.getCard_status());
        card.setCurrency(cardDto.getCurrency());
        session.save(card);
    }

    @Override
    public void deleteCardByCardNumber(String cardNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Card WHERE cardNumber = :searchedCardNumber";
        Query<Card> query = session.createQuery(hql, Card.class);
        query.setParameter("searchedCardNumber", cardNumber);
        Card card = query.uniqueResult();
        if (card != null) {
            session.delete(card);
            session.flush();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getAllCards() {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT new by.nata.data.entity.Card(c.cardId, c.accountId, c.cardNumber, c.balance, c.expiryDate, c.cvv, c.card_status,m c.currency) FROM Card c";
        Query<Card> query = session.createQuery(hql, Card.class);
        List<Card> cards = query.getResultList();

        List<CardDto> cardDtos = new ArrayList<>();

        for (Card card : cards) {
            cardDtos.add(convertToDto(card));
        }

        return cardDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public CardDto findByCardNumber(String cardNumber) {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "from Card WHERE cardNumber = :searchedCardNumber";
        Query<Card> query = session.createQuery(hql, Card.class);
        query.setParameter("searchedCardNumber", cardNumber);
        Card card = query.uniqueResult();

        if (card != null) {
            return convertToDto(card);
        }
        return null;
    }
    private CardDto convertToDto(Card card){
        return new CardDto(
                card.getCardId(),
                convertToDto(card.getAccountId()),
                card.getCardNumber(),
                card.getBalance(),
                card.getExpiryDate(),
                card.getCvv(),
                card.getCard_status(),
                card.getCurrency()
        );
    }

    private AccountDto convertToDto(Account account) {
        return new AccountDto(
                account.getAccountId(),
                convertToDto(account.getClient()),
                account.getAccountNumber(),
                account.getDateOpen(),
                account.getBalance(),
                account.getCurrency(),
                account.getPin());
    }

    private ClientDto convertToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole(),
                convertToDto(client.getClientDetails()),
                convertToDto(client.getClientAddress())
        );
    }

    private ClientDetailsDto convertToDto(ClientDetails clientDetails) {

        return new ClientDetailsDto(clientDetails.getId(),
                clientDetails.getSurname(),
                clientDetails.getName(),
                clientDetails.getBirthDate(),
                clientDetails.getPassportNumber(),
                clientDetails.getIdentityNumber(),
                clientDetails.getDateIssue(),
                clientDetails.getDateExpiry());
    }

    private ClientAddressDto convertToDto(ClientAddress clientAddress) {
        return new ClientAddressDto(clientAddress.getId(),
                clientAddress.getCountry(),
                clientAddress.getCity(),
                clientAddress.getStreet(),
                clientAddress.getHouseNumber(),
                clientAddress.getFlatNumber(),
                clientAddress.getPhoneNumber());
    }
}
