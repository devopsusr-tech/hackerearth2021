package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Patient;
import restapi.dto.Vaccination;
import restapi.repositories.PatientRepository;
import restapi.repositories.VaccinationRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class VaccinationController {

    @Autowired
    public VaccinationRepository vaccinationRepository;

    @RequestMapping("/")
    public String getIFVersion(){
        return "\"Vaccathon v.1.0\"";
    }

    @RequestMapping(value = "/findAllVaccinations")
    public List<Vaccination> getAllVaccinations(){
        return vaccinationRepository.findAll();
    }

    @PostMapping(value = "/createVaccination")
    public String createPatient(@RequestBody Vaccination vaccination){
        vaccinationRepository.insert(vaccination);
        return "Vaccination created ";
    }

    @GetMapping("/findAllVaccinations/{id}")
    public Optional<Vaccination> getVaccination(@PathVariable long id){
        return vaccinationRepository.findById(id);
    }
}
