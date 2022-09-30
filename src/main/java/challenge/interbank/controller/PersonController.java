package challenge.interbank.controller;

import challenge.interbank.dao.PersonRepository;
import challenge.interbank.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Person> getEmployeesByCode(@PathVariable Integer code) {

        return repository.findByCode(code);
    }

    @PutMapping("/updatePerson")
    public void updatePerson(@RequestBody Person person) {
        repository.save(person);
    }

}
