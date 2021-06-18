package one.digitalinnovation.personapi.cursoDigitalInnovation.utils;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.PersonDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Yhann";
    private static final String LAST_NAME = "Gomes";
    private static final String CPF_NUMBER = "043.486.550-81";
    private static final long PERSON_ID = 4L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
    return PersonDTO.builder()
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate("04/04/2010")
            .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
            .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
