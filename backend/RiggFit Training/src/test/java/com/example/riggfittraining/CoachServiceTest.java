package com.example.riggfittraining;

import com.example.riggfittraining.Entities.User.Coach;
import com.example.riggfittraining.Repositories.CoachRepository;
import com.example.riggfittraining.Services.CoachService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.logging.Logger;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class CoachServiceTest {
    Logger logger = LoggerFactory.getLogger(CoachServiceTest.class);

    @Mock
    private CoachRepository coachRepo;

    @InjectMocks
    private CoachService coachService;

    public CoachServiceTest() {
        try {
            MockitoAnnotations.openMocks(this);
        } catch (Exception e) {
            System.err.println("Error mocking CoachServiceTest for testing: " + e.getMessage());
        }
    }


    @Test
    public void testCreateCoach() {
        coachService.createCoach("Lachie", "Rigg", "user@user.com", "lrigg", "password");
        verify(coachRepo).save(any(Coach.class));
    }

    @Test
    public void testDeleteCoach() {
        Long id = coachService.createCoach("Lachie", "Rigg", "user@user.com", "lrigg", "password");
        System.out.println("ID: " + id);
        verify(coachRepo).save(any(Coach.class));
        coachService.deleteCoach(coachService.getCoach(id));
        verify(coachRepo).delete(any(Coach.class));
    }

    @Test
    public void testGetCoach() {
        // Test the getCoach method
    }


}
