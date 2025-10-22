package demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

// This annotation encapsulates the layers controller-service to call the repo
@RestResource(path="teams", rel="team")
public interface TeamRepository extends CrudRepository<Team,Long> {



}
