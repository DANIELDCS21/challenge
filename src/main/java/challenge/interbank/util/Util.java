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


    public static Person getPerson(Person person){

        byte[]encryptedBytes = Base64.getDecoder().decode(person.getCode());
        String encryptedString = new String(encryptedBytes);

        return  Person.builder()
                .code(encryptedString)
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .documentType(person.getDocumentType())
                .documentNumber(person.getDocumentNumber())
                .build();
    }

    //algo
    //probando
    //cambios
}
