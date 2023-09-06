package pl.kurs.clinictest.fixtures;

import lombok.NoArgsConstructor;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.models.Patient;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public class TestDataFixtures {
    public static final Doctor doctor_1 = Doctor.builder()
            .id(1)
            .firstName("Tomasz")
            .lastName("Kowolski")
            .speciality("reumatolog")
            .build();
    public static final Doctor doctor_2 = Doctor.builder()
            .id(2)
            .firstName("Jan")
            .lastName("Nowak")
            .speciality("okulista")
            .build();
    public static final Collection<Doctor> doctors = List.of(doctor_1, doctor_2);

    public static final Patient patient_1 = Patient.builder()
            .id(1)
            .firstName("Maciej")
            .lastName("Stonoga")
            .build();
    public static final Patient patient_2 = Patient.builder()
            .id(2)
            .firstName("Stanisław")
            .lastName("Fietko")
            .build();

    public static final Collection<Patient> patients = List.of(patient_1, patient_2);
}