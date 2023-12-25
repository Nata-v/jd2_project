package by.nata.data.dao;

import by.nata.data.entity.Card;
import by.nata.data.entity.Client;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class CardDao extends BaseDao<String, Card>{

    public CardDao(SessionFactory sessionFactory) {
        super(sessionFactory,Card.class);
    }

}
