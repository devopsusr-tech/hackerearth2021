package restapi.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class TestPerson {
    private static final Long nationalInsuranceNumber = 123456L;
    private static final String firstName = "Max";
    private static final String lastName = "Mustermann";
    private static final Date birthDay = new Date(1991,12,12);
    private static final String email = "max.mustermann@vaccathon.com";
    private static final String phone = "00431523535";
    private static final String city = "Vienna";
    private Person person = new Person(nationalInsuranceNumber,firstName,lastName,birthDay,email,phone,city);

    @Test
    void checkLastName() {
        assertEquals(lastName,person.getLastName());
    }
    @Test
    void checkSettingEmail() {
        String newEmail = "test@test.de";
        person = person.setEmail(newEmail);
        assertEquals(newEmail,person.getEmail());
    }

}