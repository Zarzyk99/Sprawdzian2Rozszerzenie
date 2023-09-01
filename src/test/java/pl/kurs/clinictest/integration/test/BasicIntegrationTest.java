package pl.kurs.clinictest.integration.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.kurs.clinictest.config.ClinicAppTestConfig;

@SpringJUnitConfig(ClinicAppTestConfig.class)
@ActiveProfiles(profiles = {"dev", "test"})
class BasicIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void run() {
        Assertions.assertNotNull(applicationContext);
    }
}
