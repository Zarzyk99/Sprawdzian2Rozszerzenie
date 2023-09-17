package pl.kurs.clinicapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;

import java.io.IOException;
import java.util.List;

@Service
public class DataImportService implements IDataImportService {
    @Autowired
    private IDataParserService parserService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IVisitService visitService;

    @Value("${data.import.paths.doctors}")
    private String doctorsPath;
    @Value("${data.import.paths.patients}")
    private String patientsPath;
    @Value("${data.import.paths.visits}")
    private String visitsPath;

    @Override
    public void importObjectsToDataBase() throws IOException {

        List<Doctor> doctors = parserService.parseDoctors(doctorsPath);

        for (Doctor doctor : doctors) {
            doctorService.saveDoctor(doctor);
        }

        List<Patient> patients = parserService.parsePatients(patientsPath);

        for (Patient patient : patients) {
            patientService.savePatient(patient);
        }

        List<Visit> visits = parserService.parseVisits(visitsPath);
        visitService.switchValidation();

        for (Visit visit : visits) {
            visitService.saveVisit(visit);
        }
        visitService.switchValidation();
    }

}
