package by.nata.web.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.Assert.*;
@Configuration
@Import(WebConfiguration.class)
public class WebConfigurationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void templateResolver() {
    }

    @Test
    public void templateEngine() {
    }

    @Test
    public void viewResolver() {
    }

    @Test
    public void addResourceHandlers() {
    }

    @Test
    public void multipartResolver() {
    }
}