package com.example.riggfittraining.Services;

import com.example.riggfittraining.Entities.User.Coach;
import com.example.riggfittraining.Repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CoachService {
    private final CoachRepository coachRepo;
    private final static Logger logger = LoggerFactory.getLogger(CoachService.class);

    @Autowired
    public CoachService(CoachRepository coachRepo) {
        this.coachRepo = coachRepo;
    }

    /**
     * Creates a new coach based on the parameters given
     * by the user and adds the coach to the database.
     *
     * @param firstName First name of the new coach
     * @param lastName Last name of the new coach
     * @param email Email of the new coach
     * @param username Username of the new coach
     * @param password Password of the new coach
     */
    public void createCoach(String firstName, String lastName, String email, String username, String password) {
        Coach newCoach = new Coach(firstName, lastName, email, username, password);
        coachRepo.save(newCoach);
    }

    /**
     * Deletes a given coach from the database
     *
     * @param c The coach to be deleted
     */
    public void deleteCoach(Coach c) {
        // Checks if the given coach is not null
        // and thus exists.
        if (c == null) {
            logger.error("Attempted to delete a non-existent coach.");
            throw new IllegalArgumentException("Cannot delete a coach that doesn't exist.");
        }
        coachRepo.delete(c);
    }

    /**
     * Retrieves a coach based on the given user id
     *
     * @param user_id ID of the coach to be deleted
     * @return The coach of object of the requested coach
     */
    public Coach getCoach(Long user_id) {
        return coachRepo.findById(user_id).orElseThrow(() -> {
            logger.error("Attempted to retrieve a coach that does not exist.");
            return new IllegalArgumentException("User " + user_id + " does not exist.");
        });
    }
}
