package pl.kurs.clinictest.integration.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IDoctorRepository;
import pl.kurs.clinicapp.repository.IPatientRepository;
import pl.kurs.clinicapp.repository.IVisitRepository;
import pl.kurs.clinicapp.services.IClinicService;
import pl.kurs.clinicapp.services.IVisitService;
import pl.kurs.clinictest.config.ClinicAppTestConfig;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringJUnitConfig(ClinicAppTestConfig.class)
@ActiveProfiles(profiles = {"dev", "test"})
public class ClinicServiceTest {

    @Autowired
    private IVisitService visitService;

    @Autowired
    private IClinicService clinicService;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IVisitRepository visitRepository;

    @BeforeEach
    void setUp() {
        LocalDate date1 = LocalDate.now().plusDays(1);
        LocalDate date2 = LocalDate.now().plusDays(2);
        LocalDate date3 = LocalDate.now().plusDays(4);

        Doctor doctor = new Doctor(1, "Weremko", "Radosław", "okulista");
        doctorRepository.save(doctor);

        Patient patient = new Patient(1, "Nowak", "Zbyszek");
        patientRepository.save(patient);

        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit(date1, patient, doctor));
        visits.add(new Visit(date2, patient, doctor));
        visits.add(new Visit(date3, patient, doctor));
        visits.forEach(visitService::saveVisit);
    }

    @AfterEach
    void clean(){
        visitRepository.deleteAll();
        doctorRepository.deleteAll();
        patientRepository.deleteAll();
    }

    @Test
    void testFindNearestPossibleAppointmentDate() {
        LocalDate date = LocalDate.now().plusDays(4);

        LocalDate result = clinicService.findNearestPossibleAppointmentDate(1, date);

        Assertions.assertEquals(LocalDate.now().plusDays(5), result);
        Assertions.assertTrue(result.isAfter(date));
    }


    @Test
    void shouldReturnPatientWithAllVisits() {
        Optional<Patient> patientWithHisVisits = clinicService.getPatientWithHisVisits(1);

        Assertions.assertFalse(patientWithHisVisits.isEmpty());

        Patient patient = patientWithHisVisits.get();

        Assertions.assertEquals(1, patient.getId());
        Assertions.assertNotNull(patient.getVisits());
        Assertions.assertEquals(3, patient.getVisits().size());
    }

}
