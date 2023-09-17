package pl.kurs.clinictest.integration.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.services.IPatientService;
import pl.kurs.clinictest.config.ClinicAppTestConfig;
import pl.kurs.clinictest.fixtures.TestDataFixtures;

import java.util.Optional;
import java.util.stream.Stream;

@SpringJUnitConfig(ClinicAppTestConfig.class)
@ActiveProfiles(profiles = {"dev", "test"})
public class PatientsIntegrationTest {

    @Autowired
    private IPatientService patientService;

    public static Stream<Arguments> shouldStorePatientsData() {
        return Stream.of(
                Arguments.of(TestDataFixtures.patient_1, 1),
                Arguments.of(TestDataFixtures.patient_2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldStorePatientsData")
    void shouldStorePatients(final Patient patient, final Integer expectedPatientId) {
        //when
        patientService.savePatient(patient);
        final Optional<Patient> patientBox = patientService.findById(expectedPatientId);

        //then
        Assertions.assertFalse(patientBox.isEmpty());
        final var resultPatient = patientBox.get();

        Assertions.assertEquals(patient.getFirstName(), resultPatient.getFirstName());
        Assertions.assertEquals(patient.getLastName(), resultPatient.getLastName());
        Assertions.assertEquals(patient.getId(), resultPatient.getId());

    }
}
