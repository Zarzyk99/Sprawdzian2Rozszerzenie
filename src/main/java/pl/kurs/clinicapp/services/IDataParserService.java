package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;

import java.io.IOException;
import java.util.List;

public interface IDataParserService {
    List<Doctor> parseDoctors(String filePath) throws IOException;

    List<Patient> parsePatients(String filePath) throws IOException;

    List<Visit> parseVisits(String filePath) throws IOException;
}
