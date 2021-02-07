package restapi.dto;
import org.springframework.data.annotation.Id;

import java.util.Date;


public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public Person setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }
}
