package pl.kurs.clinictest.integration.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.services.IDoctorService;
import pl.kurs.clinictest.config.ClinicAppTestConfig;
import pl.kurs.clinictest.fixtures.TestDataFixtures;

import java.util.Optional;
import java.util.stream.Stream;

@SpringJUnitConfig(ClinicAppTestConfig.class)
@ActiveProfiles(profiles = {"dev", "test"})
public class DoctorsIntegrationTest {

    @Autowired
    private IDoctorService doctorService;

    @ParameterizedTest
    @MethodSource("shouldStoreDoctorsData")
    void shouldStoreDoctors(final Doctor doctor, final Integer expectedDoctorId) {
        // when
        doctorService.saveDoctor(doctor);
        final Optional<Doctor> doctorBox = doctorService.findById(expectedDoctorId);

        // then
        Assertions.assertFalse(doctorBox.isEmpty());
        final var resultDoctor = doctorBox.get();

        Assertions.assertEquals(doctor.getFirstName(), resultDoctor.getFirstName());
    }

    public static Stream<Arguments> shouldStoreDoctorsData() {
        return Stream.of(
            Arguments.of(TestDataFixtures.doctor_1, 1),
            Arguments.of(TestDataFixtures.doctor_2, 2)
        );
    }
}