package pl.kurs.clinicapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
@PropertySource("classpath:application.properties")
@Slf4j
public class BaseConfiguration {
    public BaseConfiguration(@Autowired Environment environment) {
        log.info("Active Profiles: {}", Arrays.toString(environment.getActiveProfiles()));
        log.info("Application Port: {}", environment.getProperty("server.port"));
    }
}
