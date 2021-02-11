package restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.dto.VaccinationTemplate;
import restapi.repositories.VaccinationTemplateRepository;
import restapi.services.DocumentType;
import restapi.services.SequenceGeneratorService;

import java.util.List;
import java.util.Optional;

@RestController
public class VaccinationTemplateController {

    @Autowired
    public VaccinationTemplateRepository vaccinationTemplateRepository;
    @Autowired
    public SequenceGeneratorService sequenceGenerator;

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/rest/findAllVaccinationTemplates")
    public List<VaccinationTemplate> getAllPatients(){
        return vaccinationTemplateRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping(value = "/rest/createVaccinationTemplate")
    public String createPatient(@RequestBody VaccinationTemplate vaccinationTemplate){
        if(vaccinationTemplate.getId() == null || vaccinationTemplate.getId() == 0) {
            vaccinationTemplate.setId(sequenceGenerator.generateSequenceId(DocumentType.vaccinationTemplate));
        }

        VaccinationTemplate created = vaccinationTemplateRepository.insert(vaccinationTemplate);
        return "VaccinationTemplate created "+created.getDescription();
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping("/rest/findAllVaccinationTemplates/{id}")
    public Optional<VaccinationTemplate> getPatient(@PathVariable long id){
        return vaccinationTemplateRepository.findById(id);
    }
}
