package pl.kurs.clinictest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import pl.kurs.clinicapp.models.Doctor;
import pl.kurs.clinicapp.services.DataParserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataParserServiceTest {

    private DataParserService dataParserService;

    @BeforeEach
    public void init() {
        final ClassLoader classLoader = getClass().getClassLoader();
        dataParserService = new DataParserService(new DefaultResourceLoader(classLoader));
    }

    @Test
    void testParseDoctor() throws IOException {

        List<Doctor> doctors = dataParserService.parseDoctors("lekarze.txt");
        System.out.println(doctors.size());
        System.out.println(doctors);
        assertEquals(5, doctors.size());
        Doctor doctor = doctors.get(0);
        assertEquals(23, doctor.getId());
        assertEquals("Kadaj", doctor.getLastName());
        assertEquals("Monika", doctor.getFirstName());
        assertEquals("laryngolog", doctor.getSpeciality());
    }


    @Test
    void testTryParse() {
        LocalDate result = dataParserService.tryParse("2023-08-29");
        assertEquals(LocalDate.of(2023, 8, 29), result);
    }
}

