package restapi.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import restapi.dto.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Long> {
}
