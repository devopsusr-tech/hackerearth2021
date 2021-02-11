package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Doctor;
import restapi.repositories.DoctorRepository;
import restapi.services.DocumentType;
import restapi.services.SequenceGeneratorService;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    public DoctorRepository doctorRepository;
    @Autowired
    public SequenceGeneratorService sequenceGenerator;

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/rest/findAllDoctors")
    public List<Doctor> getAllPatients(){
        return doctorRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping(value = "/rest/createDoctor")
    public String createPatient(@RequestBody Doctor doctor){
        if(doctor.getNationalInsuranceNumber() == null || doctor.getNationalInsuranceNumber() == 0) {
            doctor.setNationalInsuranceNumber(sequenceGenerator.generateSequenceId(DocumentType.doctor));
        }

        Doctor createdDoctor = doctorRepository.insert(doctor);
        return "Patient created "+createdDoctor.getLastName();
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping("/rest/findAllDoctors/{id}")
    public Optional<Doctor> getPatient(@PathVariable long id){
        return doctorRepository.findById(id);
    }
}
