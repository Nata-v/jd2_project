package by.nata.data.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;


//@Repository
//@Transactional
public abstract class BaseDao<K, E> implements Dao<K, E> {

    private final SessionFactory sessionFactory;
    private final Class<E> clazz;

    public BaseDao(SessionFactory sessionFactory, Class<E> clazz) {
        this.clazz = clazz;
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
       // return entity;
    }

    @Override
    public void delete(K id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.find(clazz, id));
        session.flush();
    }

    @Override
    public void update(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        Session session = sessionFactory.getCurrentSession();
        var criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return session.createQuery(criteria).getResultList();
    }


}
