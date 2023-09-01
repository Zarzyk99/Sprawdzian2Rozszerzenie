package pl.kurs.clinicapp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kurs.clinicapp.repository.IPatientRepository;
import pl.kurs.clinicapp.repository.IVisitRepository;
import pl.kurs.clinicapp.services.ClinicService;
import pl.kurs.clinicapp.services.IClinicService;
import pl.kurs.clinicapp.services.IDoctorService;

import java.text.SimpleDateFormat;

@Configuration
public class BeansConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        mapper.findAndRegisterModules();

        return mapper;
    }

    @Bean
    public IClinicService clinicService(final IDoctorService doctorService,
                                        final IPatientRepository patientRepository,
                                        final IVisitRepository visitRepository) {
        return new ClinicService(doctorService, patientRepository, visitRepository);
    }

//    @Bean
//    public File getFile(){
//        File doctorTestFile = new File("doctor-test.txt");
//
//        return doctorTestFile;
//    }
//
//    @Bean
//    public File getFileTest
}
