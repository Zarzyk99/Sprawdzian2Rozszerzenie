package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.models.Patient;

import java.util.Optional;

public interface IPatientService {
    void savePatient(Patient patient);

    Optional<Patient> findById(Integer patientId);
}
