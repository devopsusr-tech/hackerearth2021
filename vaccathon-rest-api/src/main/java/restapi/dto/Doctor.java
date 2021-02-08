package restapi.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document
public class Doctor extends Person{
    private String hospital;

    public Doctor(Long nationalInsuranceNumber, String firstName, String lastName, Date birthDay, String email, String phone, String city, String hospital) {
        super(nationalInsuranceNumber, firstName, lastName, birthDay, email, phone, city);
        this.hospital = hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public Doctor setHospital(String hospital) {
        this.hospital = hospital;
        return this;
    }
}
