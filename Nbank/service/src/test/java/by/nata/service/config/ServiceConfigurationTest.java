package by.nata.service.config;

import by.nata.data.config.DataConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//@Configuration
@Import(ServiceConfiguration.class)
public class ServiceConfigurationTest {


}