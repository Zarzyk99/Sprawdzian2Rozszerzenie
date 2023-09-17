package pl.kurs.clinicapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataParserService implements IDataParserService {
    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-M-dd"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-M-d"))
            .toFormatter();
    private final ResourceLoader resourceLoader;

    public List<Doctor> parseDoctors(String filePath) throws IOException {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile(filePath)))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 7) {
                    Doctor doctor = new Doctor();
                    doctor.setId(Integer.parseInt(parts[0]));
                    doctor.setLastName(parts[1]);
                    doctor.setFirstName(parts[2]);
                    doctor.setSpeciality(parts[3]);
                    doctor.setBirthDate(tryParse(parts[4]));
                    doctor.setNIP(parts[5]);
                    doctor.setPesel(parts[6]);
                    doctors.add(doctor);
                }
            }
        }
        return doctors;
    }

    public List<Patient> parsePatients(String filePath) throws IOException {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile(filePath)))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    Patient patient = new Patient();
                    patient.setId(Integer.parseInt(parts[0]));
                    patient.setLastName(parts[1]);
                    patient.setFirstName(parts[2]);
                    patient.setPesel(parts[3]);
                    patient.setBirthDate(tryParse(parts[4]));
                    patients.add(patient);
                }
            }
        }
        return patients;
    }

    public List<Visit> parseVisits(String filePath) throws IOException {
        List<Visit> visits = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile(filePath)))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    Visit visit = new Visit();
                    visit.setId(0);
                    var doctor = Doctor.builder().id(Integer.parseInt(parts[0])).build();
                    visit.setDoctor(doctor);
                    var patient = Patient.builder().id(Integer.parseInt(parts[1])).build();
                    visit.setPatient(patient);
                    visit.setVisitDate(tryParse(parts[2]));
                    visits.add(visit);
                }
            }
        }
        return visits;
    }

    private File getFile(String fileName) throws IOException {
        return resourceLoader.getResource(fileName).getFile();
    }

    public LocalDate tryParse(String parameter) {
        return LocalDate.parse(parameter, DATE_FORMATTER);
    }
}
