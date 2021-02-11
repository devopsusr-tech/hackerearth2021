package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Patient;
import restapi.dto.Vaccination;
import restapi.repositories.PatientRepository;
import restapi.services.DocumentType;
import restapi.services.SequenceGeneratorService;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    public PatientRepository patientRepository;
    @Autowired
    public SequenceGeneratorService sequenceGenerator;

    @RequestMapping(value = "/findAllPatients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping(value = "/createPatient")
    public String createPatient(@RequestBody Patient patient){
        if(patient.getNationalInsuranceNumber() == null || patient.getNationalInsuranceNumber() == 0) {
            patient.setNationalInsuranceNumber(sequenceGenerator.generateSequenceId(DocumentType.patient));
        }
        Patient createdPatient = patientRepository.insert(patient);
        return "Patient created "+createdPatient.getLastName();
    }

    @GetMapping("/findAllPatients/{id}")
    public Optional<Patient> getPatient(@PathVariable long id){
        return patientRepository.findById(id);
    }

    @PostMapping(value = "/newVaccination")
    public boolean addNewVaccination(Patient patient, Vaccination vaccination){
        if (vaccination==null || patient == null)
            return false;

        patient.getVaccinationList().add(vaccination);
        return true;
    }
}
