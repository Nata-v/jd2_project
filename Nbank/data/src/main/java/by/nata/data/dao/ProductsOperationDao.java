package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.entity.ProductsOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductsOperationDao extends BaseDao<String, ProductsOperation>{
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    public ProductsOperationDao(SessionFactory sessionFactory) {
        super(sessionFactory, ProductsOperation.class);
    }


}
