package restapi.dto;

public class Doctor extends Person{
    private String hospital;

    public String getHospital() {
        return hospital;
    }

    public Doctor setHospital(String hospital) {
        this.hospital = hospital;
        return this;
    }
}
