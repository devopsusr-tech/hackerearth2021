package restapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan({ "restapi.*" })
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
            VaccinationTemplate vt4 = new VaccinationTemplate(5454554L, "Kinderimpfung: Die FSME-Impfung ist ab dem vollendeten 1. Lebensjahr zugelassen. Entsprechend den Empfehlungen der WHO16 soll in Endemiegebieten eine Impfung ab dem vollendeten 1. Lebensjahr erfolgen. Erwachsenenimpfung: Grundimmunisierung und Auffrischungsimpfungen erfolgen gemaeß dem unten angegebenen Schema. Grundimmunisierung: FSME-Immun: 2. Dosis nach 1–3 Monaten, 3. Dosis 5–12 Monate nach der 2. Dosis. Encepur: 2. Dosis nach 1–3 Monaten, 3. Dosis 9–12 Monate nach der 2. Dosis.",
                    "(sehr haeufig) Lokalreaktionen: Schmerzen, allgemeines Unwohlsein, Myalgien, Kopfschmerzen (haeufig) Kopfschmerzen, uebelkeit, Myalgie, Arthralgie, Muedigkeit, Krankheitsgefuehl, grippeaehnliche Symptome: Schweißausbrueche,Schuettelfrost (gelegentlich) Lymphadenopathie, Schwindel, Erbrechen, Fieber, Fieber ueber 38°C v.a. nach der ersten Impfung",
                    "Bavarian Nordic A/S", 1825,"FSME", ">=12 years", "0, 28 Days");
            templateRepository.save(vt4);
            VaccinationTemplate vt5 = new VaccinationTemplate(5455554L, "Kinderimpfung: Die FSME-Impfung ist ab dem vollendeten 1. Lebensjahr zugelassen. Entsprechend den Empfehlungen der WHO16 soll in Endemiegebieten eine Impfung ab dem vollendeten 1. Lebensjahr erfolgen. Erwachsenenimpfung: Grundimmunisierung und Auffrischungsimpfungen erfolgen gemaeß dem unten angegebenen Schema. Grundimmunisierung: FSME-Immun: 2. Dosis nach 1–3 Monaten, 3. Dosis 5–12 Monate nach der 2. Dosis. Encepur: 2. Dosis nach 1–3 Monaten, 3. Dosis 9–12 Monate nach der 2. Dosis.",
                    "(sehr haeufig) Lokalreaktionen: Schmerzen, allgemeines Unwohlsein, Myalgien, Kopfschmerzen (haeufig) Kopfschmerzen, uebelkeit, Myalgie, Arthralgie, Muedigkeit, Krankheitsgefuehl, grippeaehnliche Symptome: Schweißausbrueche,Schuettelfrost (gelegentlich) Lymphadenopathie, Schwindel, Erbrechen, Fieber, Fieber ueber 38°C v.a. nach der ersten Impfung",
                    "Bavarian Nordic A/S", 1825,"FSME Junior", "<12 years", "0, 28 Days");
            templateRepository.save(vt5);
            VaccinationTemplate vt6 = new VaccinationTemplate(5456554L, "Es wird mit einem Konjugatimpfstoff nach dem 2+1 Schema im 3., 5. und 12.–14. Lebensmonat geimpft. Auch Kinder mit Risiken/Indikation werden nach dem 2+1 Schema geimpft. Bei der Erwachsenenimpfung werden drei Gruppen unterschieden: Gesunde Erwachsene (>60 Jahre), Personen mit erhoehtem Risiko zu erkranken (>50 Jahre) und Personen mit hohem Risiko und dringend indizierter Impfung (alle Altersgruppen).",
                    "(haeufig) Kopfschmerz, Schwitzen, Muskel- und Gelenkschmerzen, Fieber, Unwohlsein, Schuettelfrost, Muedigkeit, Lokalreaktionen: Roetung,Schwellung, Schmerzen, Induration, Ekchymose (gelegentlich) allgemeine Hautreaktionen einschl. Pruritus, Urtikaria, unspezifischer Hautausschlag",
                    "GSK Biologicals S.A.", 2190,"Pneumokokken", ">2 years", "0, 28 Days");
            templateRepository.save(vt6);
            VaccinationTemplate vt7 = new VaccinationTemplate(5457554L, "Sobald in oesterreich zugelassene COVID-19-Impfstoffe zur Verfuegung stehen, wird seitens des Nationalen Impfgremiums geprueft, fuer welche Personengruppen diese empfohlen werden und eine entsprechende Empfehlung zur Impfung veroeffentlicht. Da davon auszugehen ist, dass diese Empfehlung basierend auf den jeweils vorliegenden Daten regelmaeßig adaptiert werden muss, wird diese außerhalb des Impfplans gesondert in eigenem eigenen Dokument abgehandelt und kuenftig unter https://www.sozialministerium.at/Corona-Schutzimpfung zur Verfuegung stehen",
                    "(sehr haeufig) Schmerzen (haeufig) Muedigkeitsgefuehle (gelegentlich) Roetung, Juckreiz, Kopfschmerzen, Fieber, Durchfall",
                    "BioNTech Manufacturing GmbH", 2190,"COVID-19", ">16 years", "0, 28 Days");
            templateRepository.save(vt7);
            VaccinationTemplate vt8 = new VaccinationTemplate(5458554L, "Indiziert bei Reisen in Endemiegebiete des tropischen Afrikas und Suedamerikas. Einmalige Lebendimpfung, danach formal lebenslanger Schutz. Bei einigen Personengruppen koennte unabhaengig von der WHO Richtlinie eine Wiederholungsimpfung jedenfalls sinnvoll sein, da sie ueber eine moeglicherweise abgeschwaechte Immunantwort verfuegen: zum Beispiel Kinder, die bei Erstimpfung unter 2 Jahre alt waren, Frauen, die in der Graviditaet geimpft wurden",
                    "(sehr haeufig) Lokalreaktion: Schmerzen, Schwellung, Roetung, Myalgien (haeufig) Lokalreaktion: Induration, Abgeschlagenheit, Arthralgien, Kopfschmerzen",
                    "Sanofi Pasteur Europe", 36500,"Gelbfieber", ">9 months", "0, 28 Days");
            templateRepository.save(vt8);
            VaccinationTemplate vt9 = new VaccinationTemplate(5459554L, "Die Schutzimpfung gegen Cholera ist im Tourismus weitgehend entbehrlich, das Risiko einer schweren dehydrierenden Erkrankung fuer touristisch reisende Personen liegt in einer Groeßenordnung von 1:3 Millionen. Nur unter speziellen Bedingungen, wie z.B. bei Choleraausbruechen nach Naturkatastrophen oder in Fluechtlingslagern sollte daran gedacht werden, vor allem dort taetige Personen zu immunisieren. Kinder vom vollendeten 2. bis zum vollendeten 6. Lebensjahr: 3 Impfdosen im Abstand von jeweils 1 bis 6 Wochen.",
                    "(sehr haeufig) Lokalreaktion: Schmerz, Roetung, Mattigkeit, Appetitlosigkeit, Reizbarkeit, Kopfschmerzen (haeufig) Schlaefrigkeit, Kopfschmerzen, gastrointestinale Beschwerden, uebelkeit, Appetitlosigkeit, Lokalreaktionen: Schwellung, Hauteinblutung, Unwohlsein, Fieber > 37,5°C, Reizbarkeit, Fieber (gelegentlich) Durchfall, Erbrechen, Abdominalschmerzen, Hautausschlag, Myalgie, Infektion der oberen Atemwege ",
                    "Emergent NL B.V.", 730,"Cholera", ">6 years", "0, 28 Days");
            templateRepository.save(vt9);

            Date dt = new Date();
            Vaccination vaccination1 = new Vaccination(54534543453455554L, vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 2j122111212jhv4b");
            vaccinationRepository.save(vaccination1);
            Vaccination vaccination2 = new Vaccination(54535686354345554L, vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 2j5456423h4b32jhv4b");
            vaccinationRepository.save(vaccination2);
            Vaccination vaccination3 = new Vaccination(54535834534558554L, vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 5646542j23h4b32jhv4b");
            vaccinationRepository.save(vaccination3);
            Vaccination vaccination4 = new Vaccination(54534354355558584L, vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 5410352j23h4b32jhv4b");
            vaccinationRepository.save(vaccination4);
            Vaccination vaccination5 = new Vaccination(54858345345553554L, vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 212122j23h4b32jhv4b");
            vaccinationRepository.save(vaccination5);
            Vaccination vaccination6 = new Vaccination(54584355853554L, vt1, dt,doctor, new Date(dt.getTime()+(86400000*vt1.getEffectDuration())), "Serial: 2884868j23h4b32jhv4b");
            vaccinationRepository.save(vaccination6);
            Vaccination vaccination7 = new Vaccination(548585854353554L, vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 51512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination7);
            Vaccination vaccination8 = new Vaccination(545353545858554L, vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 51512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination8);
            Vaccination vaccination9 = new Vaccination(5453584554348554L, vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 1512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination9);
            Vaccination vaccination10 = new Vaccination(545453343434554L, vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 15152j23h4b32jhv4b");
            vaccinationRepository.save(vaccination10);
            Vaccination vaccination11 = new Vaccination(54534545434343554L, vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 15512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination11);
            Vaccination vaccination12 = new Vaccination(54534544343554L, vt2, dt,doctor, new Date(dt.getTime()+(86400000*vt2.getEffectDuration())), "Serial: 1512j23h4b32jhv4b");
            vaccinationRepository.save(vaccination12);
            Vaccination vaccination13 = new Vaccination(545334453434554L, vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j23h4b32jhv4b");
            vaccinationRepository.save(vaccination13);
            Vaccination vaccination14 = new Vaccination(5453236532554L, vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j25153h4b32jhv4b");
            vaccinationRepository.save(vaccination14);
            Vaccination vaccination15 = new Vaccination(545345467654554L, vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 25151j23h4b32jhv4b");
            vaccinationRepository.save(vaccination15);
            Vaccination vaccination16 = new Vaccination(54535675767554L, vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j23h451515151b32jhv4b");
            vaccinationRepository.save(vaccination16);
            Vaccination vaccination17 = new Vaccination(5456767673554L, vt3, dt,doctor, new Date(dt.getTime()+(86400000*vt3.getEffectDuration())), "Serial: 2j23h4b515132jhv4b");
            vaccinationRepository.save(vaccination17);

            patientRepository.save(new Patient(12554455L, "Emir", "Cajlakovic",new Date(), "emir@gmail.com", "0699131321", "Vienna", Arrays.asList(new Vaccination[]{vaccination1, vaccination7, vaccination15})));
            patientRepository.save(new Patient(12784455L, "Lulzim", "Bulica ",new Date(), "lultim@gmail.com", "06992321", "Vienna", Arrays.asList(new Vaccination[]{vaccination2, vaccination8, vaccination16})));
            patientRepository.save(new Patient(12624455L, "Verena", "Matzenberger",new Date(), "verena@gmail.com", "0699132121", "Vienna", Arrays.asList(new Vaccination[]{vaccination3, vaccination9})));
            patientRepository.save(new Patient(12666855L, "Omid", "Jafarabadi Navidreza",new Date(), "omid@gmail.com", "0699163221", "Vienna", Arrays.asList(new Vaccination[]{vaccination4, vaccination10})));
            patientRepository.save(new Patient(12554425L, "Navid", "Jafarabadi Navidreza",new Date(), "navid@gmail.com", "069959621", "Vienna", Arrays.asList(new Vaccination[]{vaccination5, vaccination11})));
            patientRepository.save(new Patient(12554495L, "Zsolt", "Tamas",new Date(), "zslot@gmail.com", "069915421", "Vienna", Arrays.asList(new Vaccination[]{vaccination6, vaccination12})));
            patientRepository.save(new Patient(12554435L, "Bulut", "Ömer",new Date(), "oemer@gmail.com", "069954121", "Vienna", Arrays.asList(new Vaccination[]{vaccination13, vaccination14})));




        };
    };

}
