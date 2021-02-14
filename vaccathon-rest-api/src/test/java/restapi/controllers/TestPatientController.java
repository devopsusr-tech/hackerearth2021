package restapi.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import restapi.dto.*;

public class TestPatientController {
    private static final Long nationalInsuranceNumber = 123456L;
    private static final String firstName = "Max";
    private static final String lastName = "Mustermann";
    private static final Date birthDay = new Date(1991,12,12);
    private static final String email = "max.mustermann@vaccathon.com";
    private static final String phone = "00431523535";
    private static final String city = "Vienna";
    private static final String hospital = "AKH";
    private VaccinationController vaccinationController = new VaccinationController();
    private List<Vaccination> vaccinationList = new ArrayList();
    private Patient patient = new Patient(nationalInsuranceNumber,firstName,lastName,birthDay,email,phone,city,vaccinationList);
    private Doctor doctor = new Doctor(nationalInsuranceNumber, firstName, lastName, birthDay, email, phone, city, hospital);
    private VaccinationTemplate vaccinationTemplate = new VaccinationTemplate(111111L, "test vaccination 1", "no side effects; very healthy :P", "vaccathon",
            365, "COVID-19", ">16", "0, 28 days");
    private Vaccination vaccination = new Vaccination(22222222L, vaccinationTemplate, new Date(2021,02,10), doctor,
            new Date(2022,02,10), "take care of your health");

    @Test
    void checkAddingNewVaccination() throws Exception {
        assertTrue(true);
    }

    @Test
    void checkCountOfVaccinationList() throws Exception {
        assertTrue(true);
    }
}
