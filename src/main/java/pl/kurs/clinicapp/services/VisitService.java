package pl.kurs.clinicapp.services;

import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IVisitRepository;

import java.util.Optional;

@Service
public class VisitService implements IVisitService {
    private final IVisitRepository visitDao;

    public VisitService(IVisitRepository visitDao) {
        this.visitDao = visitDao;
    }

    @Override
    public void saveVisit(Visit visit) {
        visitDao.save(Optional.ofNullable(visit).orElseThrow());
    }


}
