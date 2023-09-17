package pl.kurs.clinicapp.services;

import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.exceptions.InvalidVisitDateException;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IVisitRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VisitService implements IVisitService {
    private final IVisitRepository visitDao;

    public VisitService(IVisitRepository visitDao) {
        this.visitDao = visitDao;
    }

    @Override
    public void saveVisit(Visit visit) throws InvalidVisitDateException {
        if (visit.getVisitDate().isBefore(LocalDate.now())) {
            throw new InvalidVisitDateException();
        }
        visitDao.save(Optional.ofNullable(visit).orElseThrow());
    }


}
