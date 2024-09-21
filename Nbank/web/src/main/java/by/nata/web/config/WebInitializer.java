package by.nata.web.config;

import by.nata.data.config.DataConfiguration;
import by.nata.service.config.ServiceConfiguration;
import by.nata.web.rest.RestConfiguration;
import by.nata.web.security.WebSecurityConfig;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

public class WebInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);
        context.register(ServiceConfiguration.class);
        context.register(DataConfiguration.class);
        context.register(WebSecurityConfig.class);
        context.register(RestConfiguration.class);


        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
        // servletRegistration.addMapping("*.html");
        //servletRegistration.addMapping("*.jpg");
        // *.view - GET
        // *.action - POST

        long maxSize = 10L * 1024 * 1024 * 1024;
        servletRegistration.setMultipartConfig(new MultipartConfigElement(null,
                maxSize, maxSize, 0));
    }
}

