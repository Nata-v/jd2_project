package by.nata.service.config;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.CardDao;
import by.nata.data.dao.ClientDao;
import by.nata.data.dao.TransactionsDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

@Import(ServiceConfiguration.class)
@Configuration

public class ServiceConfigurationTest {

    @Bean
    @Primary
    public ClientDao clientDao() {
        return Mockito.mock(ClientDao.class);
    }
    @Bean
    @Primary
    public AccountDao accountDao() {
        return Mockito.mock(AccountDao.class);
    }
    @Bean
    @Primary
    public TransactionsDao transactionsDao() {
        return Mockito.mock(TransactionsDao.class);
    }
    @Bean
    @Primary
    public CardDao cardDao() {
        return Mockito.mock(CardDao.class);
    }
}