package one.digitalinnovation.personapi.cursoDigitalInnovation.service;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.PersonDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;
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
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
