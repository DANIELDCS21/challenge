package challenge.interbank.util;

import challenge.interbank.model.Person;
import java.util.Base64;

public class Util {

    public static Person getPersonFormatted(Person person){

        String encryptedCode = Base64.getEncoder().encodeToString(person.getCode().getBytes());

        return  Person.builder()
                .code(encryptedCode)
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .documentType(person.getDocumentType())
                .documentNumber(person.getDocumentNumber())
                .build();
    }

    public static String getDecryptedCode(String encryptedCode){

        byte[]encryptedBytes = Base64.getDecoder().decode(encryptedCode);
        String encryptedString = new String(encryptedBytes);

        return encryptedString;
    }
}
