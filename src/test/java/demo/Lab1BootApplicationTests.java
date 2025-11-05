package demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Lab1BootApplicationTests {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private TeamCreator teamCreator;

    @InjectMocks
    private Lab1BootApplication lab1BootApplication;

    public Lab1BootApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    // Test to verify that the init method saves teams correctly
    @Test
    public void init_ShouldSaveTeams() {
        // Arrange
        List<Team> mockTeams = List.of(new Team("Location A", "Team A"), new Team("Location A", "Team B"));
        when(teamCreator.createTeams()).thenReturn(mockTeams);

        // Act
        lab1BootApplication.init();

        // Assert
        verify(teamRepository, times(1)).saveAll(mockTeams);
        assertNotNull(mockTeams, "Teams should not be null after creation.");
    }

    // Test to verify that the application context loads correctly
    @Test
    public void contextLoads_ShouldLoadApplicationContext() {
        // Act & Assert
        assertDoesNotThrow(() -> Lab1BootApplication.main(new String[]{}), "Application context should load without exceptions.");
    }

    // Test to verify that the createTeams method in TeamCreator is called during initialization
    @Test
    public void init_ShouldCallCreateTeams() {
        // Arrange
        List<Team> mockTeams = List.of(new Team("Location A", "Team A"), new Team("Location A", "Team B"));
        when(teamCreator.createTeams()).thenReturn(mockTeams);

        // Act
        lab1BootApplication.init();

        // Assert
        verify(teamCreator, times(1)).createTeams();
    }

    // Test to verify that saveAll is called with the correct teams
    @Test
    public void init_ShouldCallSaveAllWithCorrectTeams() {
        // Arrange
        List<Team> mockTeams = List.of(new Team("Location A", "Team A"), new Team("Location A", "Team B"));
        when(teamCreator.createTeams()).thenReturn(mockTeams);

        // Act
        lab1BootApplication.init();

        // Assert
        verify(teamRepository, times(1)).saveAll(mockTeams);
        assertEquals(2, mockTeams.size(), "The number of teams saved should match the number of teams created.");
    }
}


