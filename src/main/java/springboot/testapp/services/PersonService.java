package springboot.testapp.services;

import springboot.testapp.domain.Person;
import springboot.testapp.exceptions.PersonNotFoundException;

/**
 * @author Dervis M, 26/06/15.
 */
public interface PersonService {

    Person findById(long personId) throws PersonNotFoundException;

}
