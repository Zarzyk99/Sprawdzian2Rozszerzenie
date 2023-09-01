package pl.kurs.clinictest.fixtures;

import lombok.NoArgsConstructor;
import pl.kurs.clinicapp.models.Doctor;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public class TestDataFixtures {
    public static final Doctor doctor_1 = Doctor.builder().id(1).firstName("jan").lastName("kowolsky").build();
    public static final Doctor doctor_2 = Doctor.builder().id(2).firstName("jan").lastName("kowolsky").build();

    public static final Collection<Doctor> doctors = List.of(doctor_1, doctor_2);
}