package by.nata.data.dao;

import by.nata.data.entity.IssuingAuthority;
import by.nata.data.model.CitiesDto;
import by.nata.data.model.IssuingAuthorityDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Repository
//@Transactional
public class IssuingAuthorityDaoImpl implements IssuingAuthorityDao{
//@Autowired
//    private SessionFactory sessionFactory;
//    private Session session;
//
//    public IssuingAuthorityDaoImpl(SessionFactory sessionFactory ){
//        super(sessionFactory, IssuingAuthority.class);
//
//    }
    private final SessionFactory sessionFactory;
   // @Autowired
    public IssuingAuthorityDaoImpl(SessionFactory sessionFactory) {
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

//    @Override
//    public IssuingAuthorityDto save(IssuingAuthorityDto issuingAuthorityDto) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(issuingAuthorityDto);
//        return issuingAuthorityDto;
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
//
//    @Override
//    public void update(IssuingAuthorityDto entity) {
//
//    }
//
//    @Override
//    public Optional<IssuingAuthorityDto> findById(String id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<IssuingAuthorityDto> findAll() {
//        return null;
//    }
}
