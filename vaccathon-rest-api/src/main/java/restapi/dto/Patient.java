package restapi.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;


@Document
public class Patient extends Person{
    @DBRef
    private Collection<Vaccination> vaccinationList;

    public Patient(Long nationalInsuranceNumber, String firstName, String lastName, Date birthDay, String email, String phone, String city, Collection<Vaccination> vaccinationList) {
        super(nationalInsuranceNumber, firstName, lastName, birthDay, email, phone, city);
        this.vaccinationList = vaccinationList;
    }

    public Collection<Vaccination> getVaccinationList() {
        return vaccinationList;
    }

    public Patient setVaccinationList(Collection<Vaccination> vaccinationList) {
        this.vaccinationList = vaccinationList;
        return this;
    }
}
