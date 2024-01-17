package by.nata.data.config;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;



//@Configuration
@Import(DataConfiguration.class)

public class DataConfigurationTest {

//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Test
//    public void sessionFactory() {
//        assertNotNull(sessionFactory);
//    }
}