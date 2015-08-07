# Spring Boot Test App
An sample backend application with a simple REST API. The application can is a quick start application used to test
Vagrant + Docker + Java.

#### Features
The application on the *master* branch has:
- HSQLDB in-memory database for fast prototyping
- Flyway to automatically handle database schema migration and version control (http://flywaydb.org/)
- Spring Data JPA for automatically generating data repositories

Additional features are provided on separate branches:

- *WithAopMetrics*: Spring Actuators for metrics and monitoring. Demonstrates how to use AOP to create custom metrics.

#### Deploying and testing on Vagrant (with Docker)

Testing the application in a isolated environment with Vagrant and Docker requires two files, Vagrantfile and Dockerfile. 
These are provided in the vagrant_docker folder in this repository.

How to (for Mac / Linux):

1. Make sure you have Homebrew Cask installed:
http://sourabhbajaj.com/mac-setup/Homebrew/Cask.html

2. Install Vagrant and Vagrant-Manager. See this excellent guide for easy setup:
http://sourabhbajaj.com/mac-setup/Vagrant/README.html

Note: The guide adds a Vagrant Ubuntu 12.04 box for demonstration purposes. This is *optional*.

3. cd into the /vagrant_docker/vagrant folder, and then into one of the provided containers
(nb: The boot2docker image does not support port forwarding! Use puphpet instead)

4. Enter "vagrant up" to start Vagrant (which in turn provisions Docker automatically)


#### REST API

The application has a single REST endpoint:

Endpoint | Method | Action 
-------- | ------ | ------
/hello | GET | Returns a list of people
/hello | POST | Create a new person
/hello/{personId} | GET | Find a person by id (included in the *WithAopMetrics* branch)

#### Running the application locally

Simply run the SpringBootTestAppApplication.java from your favourite IDE or use the following Maven command to automatically build 
and run the application (you can then use any REST-test client to test the endpoint)

```shell
mvn clean package -DskipTests=true && java -jar target/springboot.testapp-0.0.1-SNAPSHOT.jar springboot.testapp.SpringBootTestAppApplication
```

### Reference docs and guides
- https://github.com/spring-projects/spring-data-jpa
- https://github.com/spring-projects/spring-boot/tree/v1.2.4.RELEASE/spring-boot-samples
- https://github.com/spring-projects/spring-boot/tree/v1.2.4.RELEASE/spring-boot-samples/spring-boot-sample-flyway
- http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html