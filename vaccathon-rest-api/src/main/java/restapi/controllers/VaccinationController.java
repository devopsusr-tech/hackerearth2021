package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Patient;
import restapi.dto.Vaccination;
import restapi.repositories.PatientRepository;
import restapi.repositories.VaccinationRepository;
import restapi.services.DocumentType;
import restapi.services.SequenceGeneratorService;

import java.util.List;
import java.util.Optional;

@RestController
public class VaccinationController {

    @Autowired
    public VaccinationRepository vaccinationRepository;
    @Autowired
    public SequenceGeneratorService sequenceGenerator;

    @Autowired
    public PatientRepository patientRepository;

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping("/rest")
    public String getIFVersion(){
        return "\"Vaccathon v.1.0\"";
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/findAllVaccinations")
    public List<Vaccination> getAllVaccinations(){
        return vaccinationRepository.findAll();
    }


    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping(value ="/createVaccination")
    public Vaccination createVaccination(@RequestBody Vaccination vaccination) throws Exception {
        Optional<Patient> optPatient = patientRepository.findById(1L);
        Patient patient = optPatient.get();
        if (optPatient == null) {
            throw new Exception("Not found!"); //TODO change response
        }
        if(vaccination.getProductNumber() == null || vaccination.getProductNumber() == 0) {
            vaccination.setProductNumber(sequenceGenerator.generateSequenceId(DocumentType.vaccination));
        }
        vaccinationRepository.save(vaccination);
        patient.getVaccinationList().add(vaccination);
        patientRepository.save(patient);
        return vaccination;
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping("/findAllVaccinations/{id}")
    public Optional<Vaccination> getVaccination(@PathVariable long id){
        return vaccinationRepository.findById(id);
    }
}
