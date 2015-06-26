package springboot.testapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.testapp.domain.Person;
import springboot.testapp.exceptions.PersonNotFoundException;
import springboot.testapp.repository.PersonRepository;

/**
 * @author Dervis M, 26/06/15.
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(long personId) throws PersonNotFoundException {
        return personRepository.findById(personId).
                orElseThrow(() -> new PersonNotFoundException("Person does not exist."));
    }
}
