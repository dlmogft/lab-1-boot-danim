package demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Spring boot application main class
 *
 * The data is created with @PostConstruct init method and saved in the H2 database
 * that is created in memory on startup
 */
@SpringBootApplication
public class Lab1BootApplication {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamCreator teamCreator;

    @PostConstruct
    public void init() {
        List<Team> teams = teamCreator.createTeams();
        teamRepository.saveAll(teams);
    }

	public static void main(String[] args) {
		SpringApplication.run(Lab1BootApplication.class, args);
	}

}
