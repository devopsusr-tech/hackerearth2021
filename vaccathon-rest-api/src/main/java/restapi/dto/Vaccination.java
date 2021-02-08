package restapi.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Vaccination {
    private VaccinationTemplate template;
    private Date applicationDate;
    private Doctor doctor;
    private Date expirationDate;
    private String remark;

    public Vaccination(VaccinationTemplate template, Date applicationDate, Doctor doctor, Date expirationDate, String remark) {
        this.template = template;
        this.applicationDate = applicationDate;
        this.doctor = doctor;
        this.expirationDate = expirationDate;
        this.remark = remark;
    }

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
