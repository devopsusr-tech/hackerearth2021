package restapi.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;


@Document(collation = "person")
public class Patient extends Person{
    @DBRef
    private Collection<Vaccination> vaccinationList;

    public Collection<Vaccination> getVaccinationList() {
        return vaccinationList;
    }

    public Patient setVaccinationList(Collection<Vaccination> vaccinationList) {
        this.vaccinationList = vaccinationList;
        return this;
    }
}
