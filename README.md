# lab-1-boot-danim

This is a Spring Boot application example that displays teams and players stored in a H2 database created on the application startup.
The teams and players to be displayed are created as Java classes annotated by @Entity and loaded by repository classes that extend @CrudRepository

# Starting the application

Start the Java class annotated by @SpringBootApplication and test the URLs to load the teams and players:
- The URL http://localhost:8080/teams loads the complete list of teams with their players
- The URL http://localhost:8080/teams/1 loads the team with the specified number with its players
- The URL http://localhost:8080/teams/1/players loads the players from the team with the specified number
- The URL http://localhost:8080/teams/1?format=xml loads the team with the specified number in XML format

# Dependencies

Spring Web, Thymeleaf, Spring Data JPA, HyperSQL Database, Spring Boot Actuator
  
# Tips

- The entity classes **Player** and **Team** are annotated with **@Entity** and have an id field annotated with **@Id** and **@GeneratedValue** in order to be saved in the H2 database through JPA
- The repository classes **TeamRepository** and **PlayerRepository** inherit from **CrudRepository** and are annotated with **@RestResource**, that is used to encapsulate controler and service layers
- The **TeamController** saves the teams and players in the database using a **@PostConstruct** method. It has to be annotated with **@RestController** only if the TeamRepository and PlayerRepository are NOT annotated with @RestResource, to avoid interfering
- The **HelloControler** is a simple example of using thymeleaf to show the resources/templates/hello.html page
