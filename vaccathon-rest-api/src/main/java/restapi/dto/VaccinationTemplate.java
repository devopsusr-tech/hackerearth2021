package restapi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "vaccinationTemplate")
public class VaccinationTemplate {
    @Id
    private Long id;
    private String description;
    private String sideEffects;
    private String company;
    private Integer effectDuration;
    private String type;
    private String targetGroup;

    public String getDescription() {
        return description;
    }

    public VaccinationTemplate setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public VaccinationTemplate setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public VaccinationTemplate setCompany(String company) {
        this.company = company;
        return this;
    }

    public Integer getEffectDuration() {
        return effectDuration;
    }

    public VaccinationTemplate setEffectDuration(Integer effectDuration) {
        this.effectDuration = effectDuration;
        return this;
    }

    public Long getId() {
        return id;
    }

    public VaccinationTemplate setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public VaccinationTemplate setType(String type) {
        this.type = type;
        return this;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public VaccinationTemplate setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
        return this;
    }
}

