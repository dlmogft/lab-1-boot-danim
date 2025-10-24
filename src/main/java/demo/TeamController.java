package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller to get the different teams with its players
 *
 * http://localhost:8080/teams
 * http://localhost:8080/teams/1
 * http://localhost:8080/teams/1/players
 *
 * The @RestController annotation is commented to avoid interfering with the @RestResource annotation in the repositories
 *
 */
// @RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/teams")
    public Iterable<Team> getTeams() {
        // return createTeams()
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamRepository.findById(id).get();
    }

    private List<Team> createTeams() {
        List<Team> teams = new ArrayList<>();
        long id = 0L;
        teams.add(new Team(id++, "Harlem", "Globertroters"));
        teams.add(new Team(id++, "Washington", "Generals"));
        teams.add(new Team(id++, "Los Angeles", "Lakers"));
        teams.add(new Team(id++, "Boston", "Celtics"));
        teams.add(new Team(id++, "Detroit", "Pistons"));
        teams.add(new Team(id++, "New York", "Knicks"));
        teams.add(new Team(id++, "Seattle", "Supersonics"));
        return teams;
    }

}
