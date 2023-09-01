package pl.kurs.clinictest.config;

import org.springframework.context.annotation.*;
import pl.kurs.clinicapp.repository.IVisitRepository;
import pl.kurs.clinictest.mocks.VisitRepositoryMock;

@Configuration
@ComponentScan(basePackages = "pl.kurs.clinicapp")
@PropertySource("classpath:application-test.properties")
public class ClinicAppTestConfig {

//    @Bean
    @Primary
    public IVisitRepository visitRepository() {
        return new VisitRepositoryMock();
    }

}
