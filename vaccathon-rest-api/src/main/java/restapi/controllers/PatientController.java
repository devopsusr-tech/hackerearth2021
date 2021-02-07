package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Patient;
import restapi.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    public PatientRepository patientRepository;

    @RequestMapping("/")
    public String getIFVersion(){
        return "v.1.0";
    }

    @RequestMapping(value = "/findAllPatients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping(value = "/createPatient")
    public String createPatient(@RequestBody Patient patient){
        Patient createdPatient = patientRepository.insert(patient);
        return "Patient created "+createdPatient.getLastName();
    }

    @GetMapping("/findAllPatients/{id}")
    public Optional<Patient> getPatient(@PathVariable long id){
        return patientRepository.findById(id);
    }
}
