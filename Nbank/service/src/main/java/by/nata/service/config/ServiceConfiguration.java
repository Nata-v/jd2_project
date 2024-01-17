package by.nata.service.config;

import by.nata.data.config.DataConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.nata.service")
@Import(DataConfiguration.class)
public class ServiceConfiguration {
}
