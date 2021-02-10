package restapi.services;

public enum DocumentType {
    doctor (10),
    patient (20),
    vaccination (30),
    vaccinationTemplate (40);

    int prefix;

    DocumentType(int prefix) {
        this.prefix = prefix;
    }

    public int getPrefix() {
        return this.prefix;
    }
}
