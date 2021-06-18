package one.digitalinnovation.personapi.cursoDigitalInnovation.repository;

import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
