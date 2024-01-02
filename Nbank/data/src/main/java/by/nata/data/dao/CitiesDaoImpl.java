package by.nata.data.dao;

import by.nata.data.model.CitiesDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Repository
//@Transactional
public class CitiesDaoImpl implements CitiesDao{
    private final SessionFactory sessionFactory;
    //@Autowired
    public CitiesDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

//    @Override
//    public CitiesDto save(CitiesDto citiesDto) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(citiesDto);
//        return citiesDto;
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
//
//    @Override
//    public void update(CitiesDto entity) {
//
//    }
//
//    @Override
//    public Optional<CitiesDto> findById(String id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<CitiesDto> findAll() {
//        return null;
//    }
}
