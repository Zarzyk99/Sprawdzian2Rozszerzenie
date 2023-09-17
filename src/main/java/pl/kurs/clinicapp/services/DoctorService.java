package pl.kurs.clinicapp.services;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.repository.IDoctorRepository;

import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {
    private final IDoctorRepository doctorDao;

    public DoctorService(IDoctorRepository doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorDao.save(Optional.ofNullable(doctor).orElseThrow());
    }

    @Override
    public Optional<Doctor> findById(@NonNull Integer doctorId) {
        return doctorDao.findById(doctorId);
    }
}
