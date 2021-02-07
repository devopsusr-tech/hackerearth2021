package restapi.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import restapi.dto.Patient;
import restapi.dto.Vaccination;

@Repository
public interface VaccinationRepository extends MongoRepository<Vaccination, Long> {
}
