package restapi.dto;
import org.springframework.data.annotation.Id;

import java.util.Date;


public class Person {
    @Id
    private Long nationalInsuranceNumber;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;
    private String phone;
    private String city;

    public Person(Long nationalInsuranceNumber, String firstName, String lastName, Date birthDay, String email, String phone, String city) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }


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

    public Long getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public Person setNationalInsuranceNumber(Long nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Person setCity(String city) {
        this.city = city;
        return this;
    }
}
