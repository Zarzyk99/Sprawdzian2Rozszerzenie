package pl.kurs.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.clinicapp.models.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
