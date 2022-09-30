package challenge.interbank.controller;

import challenge.interbank.dao.PersonRepository;
import challenge.interbank.model.Person;
import challenge.interbank.util.Util;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/savePerson")
    public String savePerson(@RequestBody Person person) {

         repository.save(Util.getPersonFormatted(person));
        return "Person saved...";
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAll() {

        return repository.findAll();
    }

    @GetMapping("/getPerson/{code}")
    public Stream<Person> getPersonByCode(@PathVariable String code) {

        return repository.findAll()
                .stream()
                .filter(person -> person.getCode().equals(code))
                .map(filter -> repository.findByCode(filter.getCode()))
                .map(data -> Util.getPerson(data));
    }

    @PutMapping("/updatePerson")
    public void updatePerson(@RequestBody Person person) {
        repository.save(Util.getPersonFormatted(person));
    }
}
