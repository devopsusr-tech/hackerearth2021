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
    public PatientRepository patientRepository;
    @Autowired
    public SequenceGeneratorService sequenceGenerator;

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
    @PostMapping("/createVaccination/pid/{patientId}")
    public String createVaccination(@RequestBody Vaccination vaccination, @PathVariable long patientId) throws Exception {
        if(vaccination.getProductNumber() == null || vaccination.getProductNumber() == 0) {
            vaccination.setProductNumber(sequenceGenerator.generateSequenceId(DocumentType.vaccination));
        }
        vaccinationRepository.insert(vaccination);

        Optional<Patient> optPatient = patientRepository.findById(patientId);
        if(optPatient.isEmpty()) {
            throw new Exception("Not found!");
        }
        Patient existPatient = optPatient.get();
        existPatient.getVaccinationList().add(vaccination);
        patientRepository.save(existPatient);

        return "Vaccination created and added in the list of patient!";
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping("/findAllVaccinations/{id}")
    public Optional<Vaccination> getVaccination(@PathVariable long id){
        return vaccinationRepository.findById(id);
    }
}
