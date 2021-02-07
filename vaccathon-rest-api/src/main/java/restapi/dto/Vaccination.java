package restapi.dto;

import java.util.Date;

public class Vaccination {
    private VaccinationTemplate template;
    private Date applicationDate;
    private Doctor doctor;
    private Date expirationDate;

    public VaccinationTemplate getTemplate() {
        return template;
    }

    public Vaccination setTemplate(VaccinationTemplate template) {
        this.template = template;
        return this;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public Vaccination setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
        return this;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Vaccination setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }
}
