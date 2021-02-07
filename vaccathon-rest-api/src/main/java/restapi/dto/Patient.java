package restapi.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collation = "person")
public class Patient extends Person{
    private ArrayList<Vaccination> vaccinationList;


    public ArrayList<Vaccination> getVaccinationList() {
        return vaccinationList;
    }
    public Patient setVaccinationList(ArrayList<Vaccination> vaccinationList) {
        this.vaccinationList = vaccinationList;
        return this;
    }
}
