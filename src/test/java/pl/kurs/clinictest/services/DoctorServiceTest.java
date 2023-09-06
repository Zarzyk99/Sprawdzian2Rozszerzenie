package pl.kurs.clinictest.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.repository.IDoctorRepository;
import pl.kurs.clinicapp.services.DoctorService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {
    @Mock
    private IDoctorRepository doctorRepository;

    @InjectMocks
    DoctorService doctorService;

    @Test
    void testSaveDoctor() {
        Doctor doctor = new Doctor();

        doctorService.saveDoctor(doctor);

        verify(doctorRepository).save(doctor);
    }

}