package pl.kurs.clinictest.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IVisitRepository;
import pl.kurs.clinicapp.services.VisitService;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VisitServiceTest {
    @Mock
    private IVisitRepository visitRepository;

    @InjectMocks
    private VisitService visitService;

    @Test
    void testSaveVisit() {
        Visit visit = new Visit();
        visit.setVisitDate(LocalDate.now());

        visitService.saveVisit(visit);

        verify(visitRepository).save(visit);
    }
}