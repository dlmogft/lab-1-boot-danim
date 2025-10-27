# lab-1-boot-danim

This is a Spring Boot application example that displays teams and players stored in a H2 database created on the application startup.
The teams and players to be displayed are created as Java classes annotated by @Entity and loaded by repository classes that extend @CrudRepository

# Starting the application

Start the Java class annotated by @SpringBootApplication and test the URLs to load the teams and players:
- The URL http://localhost:8080/teams loads the complete list of teams with their players
- The URL http://localhost:8080/teams/1 loads the team with the specified number with its players
- The URL http://localhost:8080/teams/1/players loads the players from the team with the specified number
- The URL http://localhost:8080/teams/1?format=xml loads the team with the specified number in XML format
  
