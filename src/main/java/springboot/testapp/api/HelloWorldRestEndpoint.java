package springboot.testapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.testapp.repository.PersonRepository;
import springboot.testapp.domain.Person;

import java.util.List;

/**
 * @author Dervis M, 25/06/15.
 */

@RestController
public class HelloWorldRestEndpoint {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public List<Person> hello() throws Exception {
        return personRepository.findAll();
    }


    @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> add(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
