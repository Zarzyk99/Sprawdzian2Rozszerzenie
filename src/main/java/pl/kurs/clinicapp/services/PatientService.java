package pl.kurs.clinicapp.services;

import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.repository.IPatientRepository;
import pl.kurs.clinicapp.models.Patient;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    private final IPatientRepository patientDao;

    public PatientService(IPatientRepository patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public void savePatient(Patient patient) {
        patientDao.save(Optional.ofNullable(patient).orElseThrow());
    }

    @Override
    public Optional<Patient> findById(Integer patientId) {
        return patientDao.findById(patientId);
    }
}
