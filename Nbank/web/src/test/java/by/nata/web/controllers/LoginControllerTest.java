package by.nata.web.controllers;

import by.nata.web.config.WebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfiguration.class)
public class LoginControllerTest {
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
    public void getHomePage() throws Exception {
        //Given
        ModelAndView modelAndView = mockMvc
                .perform(get("/login"))
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView();

        // When
        assertNotNull(modelAndView);
        String viewName = modelAndView.getViewName();

        //Then
        assertEquals("login", viewName);
    }

    @Test
    public void goToInfo() throws Exception {
        ModelAndView modelAndView = mockMvc
                .perform(get("/info"))
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView();

        assertNotNull(modelAndView);
        String viewName = modelAndView.getViewName();

        assertEquals("info", viewName);
    }

    @Test
    public void login() throws Exception {
        mockMvc.perform(post("/login"))
                .andExpect(redirectedUrl("/bank"));
    }

    @Test
    public void goToMainPageWithAuthorization() throws Exception {
        User user = new User("testUser", "test", Collections.singletonList(new SimpleGrantedAuthority("USER")));
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(auth);

        mockMvc.perform(get("/bank").principal(auth))
                .andExpect(status().isOk())
                .andExpect(view().name("bank"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attribute("username", "testUser"));
    }


@Test
public void testGoToMainPageWithAdminAuthentication() throws Exception {
    User user = new User("testUser", "test", Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
    Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

    SecurityContextHolder.getContext().setAuthentication(auth);

    // Выполняем запрос к методу и проверяем результат
    mockMvc.perform(get("/bank").principal(auth))
            .andExpect(status().isOk())
            .andExpect(view().name("bank"))
            .andExpect(model().attributeExists("username"))
            .andExpect(model().attribute("username", "testUser"));
}

}