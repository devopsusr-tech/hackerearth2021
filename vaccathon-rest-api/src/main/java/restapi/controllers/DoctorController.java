package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Doctor;
import restapi.repositories.DoctorRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    public DoctorRepository doctorRepository;

    @RequestMapping(value = "/findAllDoctors")
    public List<Doctor> getAllPatients(){
        return doctorRepository.findAll();
    }

    @PostMapping(value = "/createDoctor")
    public String createPatient(@RequestBody Doctor doctor){
        Doctor createdDoctor = doctorRepository.insert(doctor);
        return "Patient created "+createdDoctor.getLastName();
    }

    @GetMapping("/findAllDoctors/{id}")
    public Optional<Doctor> getPatient(@PathVariable long id){
        return doctorRepository.findById(id);
    }
}