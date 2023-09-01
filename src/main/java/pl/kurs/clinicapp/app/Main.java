package pl.kurs.clinicapp.app;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.models.Patient;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IVisitRepository;
import pl.kurs.clinicapp.services.IClinicService;
import pl.kurs.clinicapp.services.IDoctorService;
import pl.kurs.clinicapp.services.IPatientService;
import pl.kurs.clinicapp.services.IVisitService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
@ComponentScan(basePackages = "pl.kurs.clinicapp")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

//        IDataImportService importService = context.getBean(IDataImportService.class);
//
//        try {
//            importService.importObjectsToDataBase();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        test(context);
    }

    public static void test(final AnnotationConfigApplicationContext context) {
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);

        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        IClinicService clinicService = context.getBean(IClinicService.class);
        IDoctorService doctorService = context.getBean(IDoctorService.class);
        IVisitService visitService = context.getBean(IVisitService.class);
        IPatientService patientService = context.getBean(IPatientService.class);

        Patient patient = Patient.builder().id(1).firstName("cos").lastName("cos2").birthDate(LocalDate.now()).pesel("hehe").build();
        Patient patientOnlyId = Patient.builder().id(1).build();
        patientService.savePatient(patient);

        final Doctor doctor = Doctor.builder()
                .id(1)
                .build();
        doctorService.saveDoctor(doctor);

        var visits = List.of(
                Visit.builder()
                        .id(1)
                        .doctor(doctor)
                        .patient(patientOnlyId)
                        .visitDate(LocalDate.now().minusDays(2))
                        .build(),
                Visit.builder()
                        .id(2)
                        .doctor(doctor)
                        .patient(patientOnlyId)
                        .visitDate(LocalDate.now())
                        .build()
        );

        visits.forEach(visitService::saveVisit);

        IVisitRepository visitRepository = context.getBean(IVisitRepository.class);

        Optional<Visit> visitBox = clinicService.findNearestAppointment(1, LocalDate.now());

        Optional<Visit> nearestAppointment = clinicService.findNearestAppointment(1, LocalDate.now());

        System.out.println(nearestAppointment);

        System.out.println(patientService.findById(1));

        System.out.println(visitBox);

        session.getTransaction().commit();
        session.close();
    }

}
