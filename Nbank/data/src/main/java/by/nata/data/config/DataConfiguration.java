package by.nata.data.config;

import by.nata.data.entity.Account;
import by.nata.data.entity.BankomatOperations;
import by.nata.data.entity.Card;
import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Client;
import by.nata.data.entity.ClientAddress;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Currency;
import by.nata.data.entity.Role;
import by.nata.data.entity.Transactions;
import by.nata.data.entity.TypeOperation;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "by.nata.data")
@PropertySource(value = {
        "classpath:liquibase.properties",
        "classpath:hibernate.properties"
})
@EnableTransactionManagement
public class DataConfiguration {
    @SuppressWarnings({"unused"})
    @Bean
    public Properties hibernateProperties(
            @Value("${hibernate.show_sql}") String showSql,
            @Value("true") String debug,
            @Value("${hibernate.dialect}") String dialect
    ) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", showSql);
        hibernateProperties.put("debug", debug);
        hibernateProperties.put("hibernate.dialect", dialect);
        return hibernateProperties;
    }

    @SuppressWarnings({"unused"})
    @Bean
    public DataSource dataSource(
            @Value("${url}") String url,
            @Value("${driver}") String driverClassName,
            @Value("user") String userName,
            @Value("${password}") String password,
            @Value("true") boolean removeAbandonedOnBorrow,
            @Value("10") int initialSize,
            @Value("25") int maxTotal) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setRemoveAbandonedOnBorrow(removeAbandonedOnBorrow);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        return dataSource;
    }

    //        @Bean
//        public DataSource dataSource(
//                @Value("${url}") String url,
//                @Value("${driver}") String driverClassName,
//                @Value("user") String userName,
//                @Value("${password}") String password,
//                @Value("50") int maxTotal) {
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(url);
//            config.setDriverClassName(driverClassName);
//            config.setUsername(userName);
//            config.setPassword(password);
//            config.setMaximumPoolSize(maxTotal);
//            config.addDataSourceProperty("cachePrepStmts", "true");
//            config.addDataSourceProperty("prepStmtCacheSize", "250");
//            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//            return new HikariDataSource(config);
//        }
    @SuppressWarnings({"unused"})
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource,
                                                  @Qualifier("hibernateProperties") Properties hibernateProperties) {
        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();

        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedClasses(
                Client.class,
                ClientDetails.class,
                ClientAddress.class,
                Account.class,
                Card.class,
                CardStatus.class,
                Currency.class,
                Role.class,
                TypeOperation.class,
                BankomatOperations.class,
                Transactions.class
        );
        return sessionFactory;
    }

    @SuppressWarnings({"unused"})
    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
