package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to get the different teams with its players
 *
 * <a href="http://localhost:8080/teams">...</a>
 * <a href="http://localhost:8080/teams/1">...</a>
 * <a href="http://localhost:8080/teams/1/players">...</a>
 *
 * The @RestController annotation is commented to avoid interfering with the @RestResource annotation in the repositories
 * NOTE: The URL <a href="http://localhost:8080/teams/1?format=xml">...</a> only returns XML format if it's uncommented, otherwise it returns JSON
 *
 */
@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping(value = "/teams", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Iterable<Team> getTeams() {
        // return createTeams()
        return teamRepository.findAll();
    }

    @GetMapping(value = "/teams/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Team getTeamById(@PathVariable Long id) {
        return teamRepository.findById(id).get();
    }

}
