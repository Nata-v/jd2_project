package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.entity.Card;
import by.nata.data.model.AccountDto;
import by.nata.data.model.CardDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Card getCardById(String cardId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.find(Card.class, cardId);
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        final Session session = sessionFactory.getCurrentSession();
        return session.find(Card.class, cardNumber);
        // return cardDao.findByCardNumber(cardNumber);
    }
}
