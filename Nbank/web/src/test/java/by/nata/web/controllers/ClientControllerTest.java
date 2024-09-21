package by.nata.web.controllers;

import by.nata.web.config.WebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfiguration.class)
//@AutoConfigureMockMvc
//@RequiredArgsConstructor
public class ClientControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
        mockMvc = null;
    }


    @Test
    public void addClientRegistration() throws Exception {
        ModelAndView modelAndView = mockMvc
                .perform(get("/registration"))
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView();

        assertNotNull(modelAndView);
        String viewName = modelAndView.getViewName();

        assertEquals("registration", viewName);
    }

    @Test
    public void registrationClient() {
    }
}