package restapi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Vaccination {
    @Id
    private Long productNumber;
    @DBRef
    private VaccinationTemplate template;
    private Date applicationDate;
    private Doctor doctor;
    private Date expirationDate;
    private String remark;

    public Vaccination(Long productNumber, VaccinationTemplate template, Date applicationDate, Doctor doctor, Date expirationDate, String remark) {
        this.template = template;
        this.applicationDate = applicationDate;
        this.doctor = doctor;
        this.expirationDate = expirationDate;
        this.remark = remark;
        this.productNumber = productNumber;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Vaccination setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Vaccination setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public Vaccination setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
        return this;
    }
}
