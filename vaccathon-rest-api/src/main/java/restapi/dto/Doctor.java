package restapi.dto;

import java.util.Date;

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
