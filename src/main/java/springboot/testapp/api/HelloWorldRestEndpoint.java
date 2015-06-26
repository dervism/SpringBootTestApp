package springboot.testapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.testapp.domain.Person;
import springboot.testapp.exceptions.PersonNotFoundException;
import springboot.testapp.repository.PersonRepository;
import springboot.testapp.services.PersonService;

import java.util.List;

/**
 * @author Dervis M, 25/06/15.
 */

@RestController
public class HelloWorldRestEndpoint {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public List<Person> hello() throws Exception {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/hello/{personId}", method = RequestMethod.GET, produces = "application/json")
    public Person getPerson(@PathVariable("personId") String personId) throws PersonNotFoundException {
        return personService.findById(Long.valueOf(personId));
    }


    @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> add(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
