# Spring Boot Test App
An sample backend application with a simple REST API. The application can be used as a starting point for 
rapid prototyping of REST backends.

The application on the *master* branch has:
- HSQLDB in-memory database for fast prototyping
- Flyway to automatically handle database schema migration and version control (http://flywaydb.org/)
- Spring Data JPA for automatically generating data repositories

**Additional features are provided on separate branches**

- *WithAopMetrics*: Spring Actuators for metrics and monitoring. Demonstrates how to use AOP to create custom metrics.

**The application has a single REST endpoint:**

Endpoint | Method | Action 
-------- | ------ | ------
/hello | GET | Returns a list of people
/hello | POST | Create a new person
/hello/{personId} | GET | Find a person by id (included in the *WithAopMetrics* branch)

#### Running the application

Simply run the SpringBootTestAppApplication.java from your favourite IDE or use the following Maven command to automatically build 
and run the application (when startet, you can then use any REST-test client to test the endpoint)

```shell
mvn clean package -DskipTests=true && java -jar target/springboot.testapp-0.0.1-SNAPSHOT.jar springboot.testapp.SpringBootTestAppApplication
```

### Reference docs and guides
- https://github.com/spring-projects/spring-data-jpa
- https://github.com/spring-projects/spring-boot/tree/v1.2.4.RELEASE/spring-boot-samples
- https://github.com/spring-projects/spring-boot/tree/v1.2.4.RELEASE/spring-boot-samples/spring-boot-sample-flyway
- http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html