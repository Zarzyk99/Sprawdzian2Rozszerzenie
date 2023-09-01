package pl.kurs.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.clinicapp.models.Visit;

import java.time.LocalDate;
import java.util.List;

public interface IVisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findByDoctorIdAndVisitDateLessThanEqualOrderByVisitDateDesc(Integer doctorID, LocalDate date);

    List<Visit> findByPatientId(Integer patientId);
}
