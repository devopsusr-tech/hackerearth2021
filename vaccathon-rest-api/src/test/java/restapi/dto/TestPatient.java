package restapi.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class TestPatient {
    private List<Vaccination> vaccinationList = new ArrayList();
    private Patient patient;

    @Test
    void createNewPatient() {
        patient = new Patient(123456L,"Max", "Mustermann",new Date(1991,12,12),
                  "max.mustermann@vaccathon.com", "431523535", "Vienna", vaccinationList);
        assertNotNull(patient);
    }

}