package one.digitalinnovation.personapi.cursoDigitalInnovation.controller;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.PersonDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;
import one.digitalinnovation.personapi.cursoDigitalInnovation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MessageResponseDTO> createPerson(@RequestBody @Valid PersonDTO person) {
        return ResponseEntity.ok(personService.save(person));
    }
}
