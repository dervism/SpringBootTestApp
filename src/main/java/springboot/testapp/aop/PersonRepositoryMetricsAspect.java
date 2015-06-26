package springboot.testapp.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;
import springboot.testapp.exceptions.PersonNotFoundException;

/**
 * @author Dervis M, 26/06/15.
 */

@Aspect
@Component
public class PersonRepositoryMetricsAspect {

    private final CounterService counterService;

    @Autowired
    public PersonRepositoryMetricsAspect(CounterService counterService) {
        this.counterService = counterService;
    }

    @AfterReturning(pointcut = "execution(* springboot.testapp.services.PersonService.findById(long)) && args(id)", argNames = "id")
    public void afterCallingGetGreeting(long id) {
        counterService.increment("counter.calls.personService.findById");
        counterService.increment("counter.calls.personService.findById." + id);
    }

    @AfterThrowing(pointcut = "execution(* springboot.testapp.services.PersonService.findById(long))", throwing = "e")
    public void afterCallingGetGreetingThrowsException(PersonNotFoundException e) {
        counterService.increment("counter.errors.personService.findById");
    }

}
