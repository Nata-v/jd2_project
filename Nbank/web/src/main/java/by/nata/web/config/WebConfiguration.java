package by.nata.web.config;

import by.nata.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "by.nata.web")
@PropertySource(value = {
        "classpath:app.properties",
        "classpath:messages_en.properties",
        "classpath:messages_ru.properties"
})
@Import(ServiceConfiguration.class)
@EnableWebMvc

public class WebConfiguration  implements WebMvcConfigurer  {


        private final ApplicationContext applicationContext;
    @Autowired
    public WebConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
        public SpringResourceTemplateResolver templateResolver(){
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setApplicationContext(applicationContext);
            templateResolver.setPrefix("/WEB-INF/templates/");
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode(TemplateMode.HTML);
            templateResolver.setCharacterEncoding("UTF-8");
            templateResolver.setCacheable(true);
            return templateResolver;
        }

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver() {
//
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setApplicationContext(this.applicationContext);
//        resolver.setPrefix("/WEB-INF/views/");
//        // resolver.setSuffix(".jsp");
//        resolver.setSuffix(".html");
//        return resolver;
//
//    }

        @Bean
        public SpringTemplateEngine templateEngine(){
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            templateEngine.setEnableSpringELCompiler(true);
            return templateEngine;
        }

        @Bean
        public ThymeleafViewResolver viewResolver(){
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setCharacterEncoding("UTF-8");
            viewResolver.setTemplateEngine(templateEngine());
            return viewResolver;
        }






    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("*.html")
                .addResourceLocations("/");
        registry.addResourceHandler("/static/img/*.jpg")
                .addResourceLocations("/static/img/");
        registry.addResourceHandler("/static/img/*.png")
                .addResourceLocations("/static/img/");
        registry.addResourceHandler("/static/css/*.css")
                .addResourceLocations("/static/css/");
        registry.addResourceHandler("/static/img/*.webp")
                .addResourceLocations("/static/img/");
    }


    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }


//    @Bean
//    public MessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }




    @Override
    public void addInterceptors(InterceptorRegistry registry){
      //  LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
      //  localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor());
    }
    @Bean
    public LocaleResolver localeResolver(){
      //  SessionLocaleResolver localeResolver = new SessionLocaleResolver();
var localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

}

