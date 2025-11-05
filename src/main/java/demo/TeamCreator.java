package demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TeamCreator {

    public List<Team> createTeams() {
        Set<Player> set = new HashSet<>();
        set.add(new Player("Big Easy", "Showman"));
        set.add(new Player("Buckets", "Guard"));
        set.add(new Player("Dizzy", "Guard"));

        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Harlem", "Globertrotters", set));
        teams.add(new Team("Washington", "Generals", null));
        teams.add(new Team("Los Angeles", "Lakers"));
        teams.add(new Team("Boston", "Celtics"));
        teams.add(new Team("Detroit", "Pistons"));
        teams.add(new Team("New York", "Knicks"));
        teams.add(new Team("Seattle", "Supersonics"));

        return teams;
    }

}
