package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.models.Doctor;

import java.util.Optional;

public interface IDoctorService {
    void saveDoctor(Doctor doctor);

    Optional<Doctor> findById(Integer doctorId);

}
