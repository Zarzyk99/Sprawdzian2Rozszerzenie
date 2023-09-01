package pl.kurs.clinictest.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.repository.IPatientRepository;
import pl.kurs.clinicapp.services.PatientService;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private IPatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    void testSavaPatient() {
        Patient patient = new Patient();

        patientService.savePatient(patient);

        verify(patientRepository).save(patient);
    }

}