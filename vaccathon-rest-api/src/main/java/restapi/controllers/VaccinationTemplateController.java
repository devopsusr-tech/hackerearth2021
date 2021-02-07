package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.Patient;
import restapi.dto.VaccinationTemplate;
import restapi.repositories.PatientRepository;
import restapi.repositories.VaccinationRepository;
import restapi.repositories.VaccinationTemplateRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class VaccinationTemplateController {

    @Autowired
    public VaccinationTemplateRepository vaccinationTemplateRepository;

    @RequestMapping(value = "/findAllVaccinationTemplate")
    public List<VaccinationTemplate> getAllPatients(){
        return vaccinationTemplateRepository.findAll();
    }

    @PostMapping(value = "/createVaccinationTemplate")
    public String createPatient(@RequestBody VaccinationTemplate vaccinationTemplate){
        VaccinationTemplate created = vaccinationTemplateRepository.insert(vaccinationTemplate);
        return "VaccinationTemplate created "+created.getDescription();
    }

    @GetMapping("/findAllVaccinationTemplate/{id}")
    public Optional<VaccinationTemplate> getPatient(@PathVariable long id){
        return vaccinationTemplateRepository.findById(id);
    }
}
