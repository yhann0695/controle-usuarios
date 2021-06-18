package one.digitalinnovation.personapi.cursoDigitalInnovation.service;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;
import one.digitalinnovation.personapi.cursoDigitalInnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDTO save(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
