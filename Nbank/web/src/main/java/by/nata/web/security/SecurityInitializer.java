package by.nata.web.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
@SuppressWarnings({"unused"})
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer() {
        super(WebSecurityConfig.class);
    }
}
