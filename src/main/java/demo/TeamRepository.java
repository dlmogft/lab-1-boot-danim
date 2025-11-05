package demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Repository to get the Team entries from H2 database
 * The @RestResource annotation encapsulates the layers controller-service to call the repo
 *
 * This repo exposes:
 * /teams
 * /teams/n
 * /teams/n/players
 */
@RestResource(path="teams", rel="team")
public interface TeamRepository extends CrudRepository<Team,Long> {



}
