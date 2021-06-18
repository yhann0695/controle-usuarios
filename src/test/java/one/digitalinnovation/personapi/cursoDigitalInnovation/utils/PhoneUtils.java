package one.digitalinnovation.personapi.cursoDigitalInnovation.utils;

import one.digitalinnovation.personapi.cursoDigitalInnovation.dto.PhoneDTO;
import one.digitalinnovation.personapi.cursoDigitalInnovation.entity.Phone;
import one.digitalinnovation.personapi.cursoDigitalInnovation.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 4L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
