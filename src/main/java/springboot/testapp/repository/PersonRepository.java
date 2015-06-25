package springboot.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.testapp.domain.Person;

/**
 * @author Dervis M, 25/06/15.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
