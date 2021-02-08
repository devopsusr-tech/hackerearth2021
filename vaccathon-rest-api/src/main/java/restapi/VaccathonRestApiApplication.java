package restapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import restapi.dto.Doctor;
import restapi.dto.Patient;
import restapi.dto.Vaccination;
import restapi.dto.VaccinationTemplate;
import restapi.repositories.DoctorRepository;
import restapi.repositories.PatientRepository;
import restapi.repositories.VaccinationRepository;
import restapi.repositories.VaccinationTemplateRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class VaccathonRestApiApplication {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Autowired
    private VaccinationTemplateRepository templateRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public static void main(String[] args) {
        SpringApplication.run(VaccathonRestApiApplication.class, args);
    }

    @Bean
    InitializingBean initDatabase(){
        return () -> {

            Doctor doctor = new Doctor(1255112125L, "Meier", "Michael",new Date(), "dr.meier@gmail.com", "0699131321", "Vienna", "Baumgartnerhöhe");
            doctorRepository.save(doctor);

            VaccinationTemplate vt1 = new VaccinationTemplate(5453554L, "rolling review seit 6. Okt. 2020; Antrag auf bedingte Marktzulassung bei der EMA am 1. Dez. 2020, Zulassung durch EU-Kommission am 21. Dez. 2020", "Fever, Chills, Tiredness, Headache", "BioNTech/Pfizer", 180,"mRNA + LNP", "<85 years", "0, 18 days");
            templateRepository.save(vt1);
            VaccinationTemplate vt2 = new VaccinationTemplate(5451554L, "rolling review seit 16. Nov. 2020, Antrag auf bedingte Marktzulassung bei der EMA am 30. Nov. 2020. Zulassung durch EU-Kommission am 06. Jan. 2021", "Pain, Swelling", "Moderna", 250,"mRNA-1273", "<75 years", "0, 28 days");
            templateRepository.save(vt2);
            VaccinationTemplate vt3 = new VaccinationTemplate(5452554L, "rolling review seit 01. Okt. 2020; Antrag auf bedingte Marktzulassung bei der EMA am 12. Jan. 2021", "Fever, Swelling", "Astra-Zeneca/Oxford University", 140,"AZD1222", "<55 years", "0, 28 Days");
            templateRepository.save(vt3);

            Date dt = new Date();
            Vaccination vaccination1 = new Vaccination(vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 2j122111212jhv4b");
            vaccinationRepository.save(vaccination1);
            Vaccination vaccination2 = new Vaccination(vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 2j5456423h4b32jhv4b");
            vaccinationRepository.save(vaccination2);
            Vaccination vaccination3 = new Vaccination(vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 5646542j23h4b32jhv4b");
            vaccinationRepository.save(vaccination3);
            Vaccination vaccination4 = new Vaccination(vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 5410352j23h4b32jhv4b");
            vaccinationRepository.save(vaccination4);
            Vaccination vaccination5 = new Vaccination(vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 212122j23h4b32jhv4b");
            vaccinationRepository.save(vaccination5);
            Vaccination vaccination6 = new Vaccination(vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 2884868j23h4b32jhv4b");
            vaccinationRepository.save(vaccination6);
            Vaccination vaccination7 = new Vaccination(vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 51512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination7);
            Vaccination vaccination8 = new Vaccination(vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 51512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination8);
            Vaccination vaccination9 = new Vaccination(vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 1512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination9);
            Vaccination vaccination10 = new Vaccination(vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 15152j23h4b32jhv4b");
            vaccinationRepository.save(vaccination10);
            Vaccination vaccination11 = new Vaccination(vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 15512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination11);
            Vaccination vaccination12 = new Vaccination(vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 1512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination12);
            Vaccination vaccination13 = new Vaccination(vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j23h4b32jhv4b");
            vaccinationRepository.save(vaccination13);
            Vaccination vaccination14 = new Vaccination(vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j25153h4b32jhv4b");
            vaccinationRepository.save(vaccination14);
            Vaccination vaccination15 = new Vaccination(vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 25151j23h4b32jhv4b");
            vaccinationRepository.save(vaccination15);
            Vaccination vaccination16 = new Vaccination(vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j23h451515151b32jhv4b");
            vaccinationRepository.save(vaccination16);
            Vaccination vaccination17 = new Vaccination(vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j23h4b515132jhv4b");
            vaccinationRepository.save(vaccination17);

            patientRepository.save(new Patient(12554455L, "Emir", "Cajlakovic",new Date(), "emir@gmail.com", "0699131321", "Vienna", Arrays.asList(new Vaccination[]{vaccination1, vaccination7, vaccination15})));
            patientRepository.save(new Patient(12784455L, "Lulzim", "Bulica ",new Date(), "lultim@gmail.com", "06992321", "Vienna", Arrays.asList(new Vaccination[]{vaccination2, vaccination8, vaccination16})));
            patientRepository.save(new Patient(12624455L, "Verena", "Matzenberger",new Date(), "verena@gmail.com", "0699132121", "Vienna", Arrays.asList(new Vaccination[]{vaccination3, vaccination9})));
            patientRepository.save(new Patient(12666855L, "Omid", "Jafarabadi Navidreza",new Date(), "omid@gmail.com", "0699163221", "Vienna", Arrays.asList(new Vaccination[]{vaccination4, vaccination10})));
            patientRepository.save(new Patient(12554425L, "Navid", "Jafarabadi Navidreza",new Date(), "navid@gmail.com", "069959621", "Vienna", Arrays.asList(new Vaccination[]{vaccination5, vaccination11})));
            patientRepository.save(new Patient(12554495L, "Zslot", "Tamas",new Date(), "zslot@gmail.com", "069915421", "Vienna", Arrays.asList(new Vaccination[]{vaccination6, vaccination12})));
            patientRepository.save(new Patient(12554435L, "Blut", "Ömer",new Date(), "oemer@gmail.com", "069954121", "Vienna", Arrays.asList(new Vaccination[]{vaccination13, vaccination14})));




        };
    };

}
