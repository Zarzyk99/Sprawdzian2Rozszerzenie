package pl.kurs.clinictest.integration.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IDoctorRepository;
import pl.kurs.clinicapp.repository.IVisitRepository;
import pl.kurs.clinicapp.services.IDoctorService;
import pl.kurs.clinicapp.services.IVisitService;
import pl.kurs.clinictest.config.ClinicAppTestConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.kurs.clinictest.fixtures.TestDataFixtures.doctors;

@SpringJUnitConfig(ClinicAppTestConfig.class)
@ActiveProfiles(profiles = {"dev", "test"})
class VisitsIntegrationTest {

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IVisitService visitService;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IVisitRepository visitRepository;

    @BeforeEach
    void init() {
        doctors.forEach(doctor -> doctorService.saveDoctor(doctor));
        assertEquals(doctors.size(), doctorRepository.findAll().size());
    }

    @AfterEach
    void clean() {
        visitRepository.deleteAll();
        assertEquals(0, visitRepository.findAll().size());
        doctorRepository.deleteAll();
        assertEquals(0, doctorRepository.findAll().size());
    }

    @Test
    void logicTestEtc() {
        // given
        final var doctor = doctorService.findById(1);
        Assertions.assertFalse(doctor.isEmpty());

        final var visit = Visit.builder().id(1).doctor(doctor.get()).build();

        // when
        visitService.saveVisit(visit);
        final var visitBox = visitRepository.findById(visit.getId());

        // then
        Assertions.assertFalse(visitBox.isEmpty());
    }
}
