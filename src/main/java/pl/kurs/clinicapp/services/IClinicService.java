package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.models.Patient;

import java.time.LocalDate;
import java.util.Optional;

public interface IClinicService {
    LocalDate findNearestPossibleAppointmentDate(Integer doctorId, LocalDate date);

    Optional<Patient> getPatientWithHisVisits(Integer patientId);
}
