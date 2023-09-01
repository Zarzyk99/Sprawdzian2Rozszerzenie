package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;

import java.time.LocalDate;
import java.util.Optional;

public interface IClinicService {
    Optional<Visit> findNearestAppointment(Integer doctorId, LocalDate date);

    Optional<Patient> getPatientWithHisVisits(Integer patientId);
}
