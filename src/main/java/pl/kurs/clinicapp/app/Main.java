package pl.kurs.clinicapp.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.kurs.clinicapp.services.IDataImportService;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "pl.kurs.clinicapp")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        IDataImportService importService = context.getBean(IDataImportService.class);

        try {
            importService.importObjectsToDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
