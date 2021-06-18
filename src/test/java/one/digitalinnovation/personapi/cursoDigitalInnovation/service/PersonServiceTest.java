package one.digitalinnovation.personapi.cursoDigitalInnovation.service;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.PersonDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;
import one.digitalinnovation.personapi.cursoDigitalInnovation.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.cursoDigitalInnovation.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.personapi.cursoDigitalInnovation.utils.PersonUtils.createFakeEntity;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.save(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
