package demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Lab1BootApplication {

    @Autowired
    TeamRepository teamRepository;

    @PostConstruct
    public void init() {
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

        teamRepository.saveAll(teams);
    }

	public static void main(String[] args) {
		SpringApplication.run(Lab1BootApplication.class, args);
	}

}
