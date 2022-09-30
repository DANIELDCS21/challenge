package challenge.interbank.dao;

import challenge.interbank.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByCode(Integer code);

}
