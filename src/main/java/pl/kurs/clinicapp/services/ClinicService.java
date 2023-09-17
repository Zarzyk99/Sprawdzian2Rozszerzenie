package pl.kurs.clinicapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IPatientRepository;
import pl.kurs.clinicapp.repository.IVisitRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClinicService implements IClinicService {
    private final IDoctorService doctorService;
    private final IPatientRepository patientRepository;
    private final IVisitRepository visitRepository;

    @Override
    public LocalDate findNearestPossibleAppointmentDate(Integer doctorId, LocalDate date) {
        doctorService.findById(doctorId);

        return visitRepository.findByDoctorIdAndVisitDateLessThanEqualOrderByVisitDateDesc(doctorId, date)
                .stream().max(Comparator.comparing(Visit::getVisitDate))
                .map(Visit::getVisitDate)
                .map(d -> d.plusDays(1))
                .orElse(date);
    }

    @Override
    public Optional<Patient> getPatientWithHisVisits(Integer patientId) {
        return patientRepository.findById(patientId);
    }

}
