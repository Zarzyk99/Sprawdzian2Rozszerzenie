package pl.kurs.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.clinicapp.models.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
