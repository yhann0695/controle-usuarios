package one.digitalinnovation.personapi.cursoDigitalInnovation.service;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.PersonDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;
import one.digitalinnovation.personapi.cursoDigitalInnovation.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.cursoDigitalInnovation.mapper.PersonMapper;
import one.digitalinnovation.personapi.cursoDigitalInnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private  PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO save(PersonDTO personDTO) {
        return createReturnMessage(personDTO, "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public Long deleteById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.deleteById(person.getId());
        return id;
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        return createReturnMessage(personDTO, "Updated person with ID ");
    }

    private MessageResponseDTO createReturnMessage(PersonDTO personDTO, String message) {
        Person personToCreateOrUpdate = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToCreateOrUpdate);
        return MessageResponseDTO
                .builder()
                .message(message + savedPerson.getId())
                .build();
    }
}
