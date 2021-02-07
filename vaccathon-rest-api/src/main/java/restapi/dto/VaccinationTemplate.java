package restapi.dto;

public class VaccinationTemplate {
    private Integer id;
    private String description;
    private String sideEffects;
    private String company;
    private Integer effectDuration;

    public VaccinationTemplate(Integer id, String description, String sideEffects, String company) {
        this.id = id;
        this.description = description;
        this.sideEffects = sideEffects;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public VaccinationTemplate setId(Integer id) {
        this.id = id;
        return this;
    }

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
}

