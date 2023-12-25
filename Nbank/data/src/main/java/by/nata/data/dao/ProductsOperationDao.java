package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.entity.ProductsOperation;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;


public class ProductsOperationDao extends BaseDao<String, ProductsOperation>{

    public ProductsOperationDao(SessionFactory sessionFactory) {
        super(sessionFactory, ProductsOperation.class);
    }


}
