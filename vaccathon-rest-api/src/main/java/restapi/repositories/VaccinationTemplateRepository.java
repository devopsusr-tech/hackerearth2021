package restapi.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import restapi.dto.Patient;
import restapi.dto.VaccinationTemplate;

@Repository
public interface VaccinationTemplateRepository extends MongoRepository<VaccinationTemplate, Long> {
}
