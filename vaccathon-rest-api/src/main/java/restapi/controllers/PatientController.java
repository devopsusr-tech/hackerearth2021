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
public class PatientController {

    @Autowired
    public PatientRepository patientRepository;
    @Autowired
    public VaccinationRepository vaccinationRepository;
    @Autowired
    public SequenceGeneratorService sequenceGenerator;

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/findAllPatients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping(value = "/createPatient")
    public String createPatient(@RequestBody Patient patient){
        if(patient.getNationalInsuranceNumber() == null || patient.getNationalInsuranceNumber() == 0) {
            patient.setNationalInsuranceNumber(sequenceGenerator.generateSequenceId(DocumentType.patient));
        }
        Patient createdPatient = patientRepository.insert(patient);
        return "Patient created "+createdPatient.getLastName();
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping("/addVaccination/{pid}/vaccination/{vid}")
    public String addNewVaccination(@PathVariable long pid, @PathVariable long vid) throws Exception {
        try {
            Optional<Patient> optPatient = patientRepository.findById(pid);
            Optional<Vaccination> optVaccination = vaccinationRepository.findById(vid);
            if (optPatient.isEmpty() || optVaccination.isEmpty()) {
                throw new Exception("Not found!"); //TODO change response
            }
            Patient existPatient = optPatient.get();
            Vaccination existVaccination = optVaccination.get();
            existPatient.getVaccinationList().add(existVaccination);
            patientRepository.save(existPatient);

            return "The new vaccination in the list of patient";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping("/findAllPatients/{id}")
    public Optional<Patient> getPatient(@PathVariable long id){
        return patientRepository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping(value = "/newVaccination")
    public boolean addNewVaccination(Patient patient, Vaccination vaccination){
        if (vaccination==null || patient == null)
            return false;

        patient.getVaccinationList().add(vaccination);
        return true;
    }
}
