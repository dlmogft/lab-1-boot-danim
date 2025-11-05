package demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;
import java.util.Set;

@XmlRootElement // Necessary to display the team in XML format
@Entity // Database entity object
public class Team {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String location;

    String mascot;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="teamId")
    Set<Player> players;

    public Team() {
    }

    public Team(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public Team(String location, String name, Set<Player> players) {
        this.location = location;
        this.name = name;
        this.players = players;
    }

    public Team(Long id, String location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(location, team.location) && Objects.equals(mascot, team.mascot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, mascot);
    }
}
