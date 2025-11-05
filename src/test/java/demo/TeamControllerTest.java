package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TeamControllerTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamController teamController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Helper method to create mock teams
    private List<Team> createMockTeams() {
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

    @Test
    void getTeams_ShouldReturnAllTeams() {
        // Arrange
        List<Team> mockTeams = createMockTeams();
        when(teamRepository.findAll()).thenReturn(mockTeams);

        // Act
        Iterable<Team> result = teamController.getTeams();

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(mockTeams.size(), ((List<Team>) result).size(), "Result size should match mock teams size");
        verify(teamRepository, times(1)).findAll();
    }

    @Test
    void getTeamById_ShouldReturnTeam_WhenIdExists() {
        // Arrange
        Team mockTeam = new Team(1L, "Los Angeles", "Lakers");
        when(teamRepository.findById(1L)).thenReturn(Optional.of(mockTeam));

        // Act
        Team result = teamController.getTeamById(1L);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(mockTeam.getId(), result.getId(), "Team ID should match");
        assertEquals(mockTeam.getName(), result.getName(), "Team name should match");
        assertEquals(mockTeam.getLocation(), result.getLocation(), "Team city should match");
        verify(teamRepository, times(1)).findById(1L);
    }

    @Test
    void getTeamById_ShouldThrowException_WhenIdDoesNotExist() {
        // Arrange
        when(teamRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(Exception.class, () -> teamController.getTeamById(99L), "Should throw exception when team ID does not exist");
        verify(teamRepository, times(1)).findById(99L);
    }

}
