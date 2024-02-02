package by.nata.web.security;

import by.nata.data.config.DataConfiguration;
import by.nata.data.entity.Role;
import by.nata.service.config.ServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@Import({DataConfiguration.class, ServiceConfiguration.class})
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)

public class WebSecurityConfig {

    @SuppressWarnings({"deprecation", "unused"})
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @SuppressWarnings({"unused"})
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Configure Spring security filters
        http
                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin(Customizer.withDefaults())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/", "/home", "/static/**", "/WEB-INF/templates/**").permitAll()
//                        .requestMatchers("/login", "/info", "/registration").anonymous()
//                        .requestMatchers("/logout").authenticated()
//                        .requestMatchers("/add**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .logout(Customizer.withDefaults());

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home","/static/**", "/WEB-INF/templates/**","/login", "/info", "/registration").permitAll()
                       // .requestMatchers("/admin/**").hasRole(Role.ADMIN.name())
                        .requestMatchers("/account", "/clients",  "/createCard", "/bank").authenticated()
                       // .requestMatchers(antMatcher("/client/{\\d}/delete")).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.USER.getAuthority())
                        .requestMatchers( "/api/**").anonymous()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                                .loginPage("/login")
                                .defaultSuccessUrl("/bank")
                                .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }

    @SuppressWarnings({"unused"})
    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }

}
