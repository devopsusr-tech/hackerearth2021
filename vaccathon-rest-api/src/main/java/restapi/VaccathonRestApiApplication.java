package restapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import restapi.dto.Patient;
import restapi.dto.VaccinationTemplate;
import restapi.repositories.PatientRepository;
import restapi.repositories.VaccinationRepository;
import restapi.repositories.VaccinationTemplateRepository;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class VaccathonRestApiApplication {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Autowired
    private VaccinationTemplateRepository templateRepository;

    public static void main(String[] args) {
        SpringApplication.run(VaccathonRestApiApplication.class, args);
    }

    @Bean
    InitializingBean initDatabase(){
        return () -> {

            templateRepository.save(new VaccinationTemplate(5454554L, "rolling review seit 6. Okt. 2020; Antrag auf bedingte Marktzulassung bei der EMA am 1. Dez. 2020, Zulassung durch EU-Kommission am 21. Dez. 2020", "Fever, Chills, Tiredness, Headache", "BioNTech/Pfizer", 180,"mRNA + LNP", "<85 years", 2, "0, 18 days"));
            templateRepository.save(new VaccinationTemplate(5454554L, "rolling review seit 16. Nov. 2020, Antrag auf bedingte Marktzulassung bei der EMA am 30. Nov. 2020. Zulassung durch EU-Kommission am 06. Jan. 2021", "Pain, Swelling", "Moderna", 250,"mRNA-1273", "<75 years", 2, "0, 28 days"));
            templateRepository.save(new VaccinationTemplate(5454554L, "rolling review seit 01. Okt. 2020; Antrag auf bedingte Marktzulassung bei der EMA am 12. Jan. 2021", "Fever, Swelling", "Astra-Zeneca/Oxford University", 140,"AZD1222", "<55 years", 2, "0, 28 Days"));

            patientRepository.save(new Patient(12554455L, "Emir", "Cajlakovic",new Date(), "emir@gmail.com", "0699131321", "Vienna", new ArrayList<>()));
            patientRepository.save(new Patient(12784455L, "Lulzim", "Bulica ",new Date(), "lultim@gmail.com", "06992321", "Vienna", new ArrayList<>()));
            patientRepository.save(new Patient(12624455L, "Verena", "Matzenberger",new Date(), "verena@gmail.com", "0699132121", "Vienna", new ArrayList<>()));
            patientRepository.save(new Patient(12666855L, "Omid", "Jafarabadi Navidreza",new Date(), "omid@gmail.com", "0699163221", "Vienna", new ArrayList<>()));
            patientRepository.save(new Patient(12554425L, "Navid", "Jafarabadi Navidreza",new Date(), "navid@gmail.com", "069959621", "Vienna", new ArrayList<>()));
            patientRepository.save(new Patient(12554495L, "Zslot", "Tamas",new Date(), "zslot@gmail.com", "069915421", "Vienna", new ArrayList<>()));
            patientRepository.save(new Patient(12554435L, "Blut", "Ömer",new Date(), "oemer@gmail.com", "069954121", "Vienna", new ArrayList<>()));




        };
    };

}
