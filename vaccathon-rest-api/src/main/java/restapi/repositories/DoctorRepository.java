package restapi.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import restapi.dto.Doctor;
import restapi.dto.Patient;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, Long> {
}
