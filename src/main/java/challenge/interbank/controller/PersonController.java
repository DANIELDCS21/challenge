package challenge.interbank.controller;

import challenge.interbank.dao.PersonRepository;
import challenge.interbank.model.Person;
import java.util.List;
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

        repository.save(person);
        return "Person saved..";
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAll() {

        return repository.findAll();
    }

    @GetMapping("/getPerson/{code}")
    public Person getEmployeesByCode(@PathVariable String code) {

        return repository.findByCode(code);
    }

    @PutMapping("/updatePerson")
    public void updatePerson(@RequestBody Person person) {
        repository.save(person);
    }
}
