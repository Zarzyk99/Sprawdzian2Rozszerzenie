package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.models.Visit;

public interface IVisitService {
    void saveVisit(Visit visit);

    void switchValidation();

}
