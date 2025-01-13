package com.example.riggfittraining.Entities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Class for the Client User
 *
 * @author lachierigg
 * @since 1.0
 */

@Entity
@Table(name="clients")

public class Client extends User {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    /**
     * Default constructor for the Client class
     */
    public Client() {};

    /**
     * Constructor for the Client class
     *
     * @param firstName The first name of the client
     * @param lastName The last name of the client
     * @param email The email of the client
     * @param username The username of the client
     * @param password The password of the client
     */
    public Client(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password);
        this.coaches = new ArrayList<>();
    };

    /**
     * Clients list of coaches where
     * the client may have more than one coach.
     */
    @ManyToMany(mappedBy = "clients")
    private ArrayList<Coach> coaches;

    /**
     * Returns the list of coaches that train the client
     *
     * @return List of Coaches
     */
    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    /**
     * Adds a new a coach to the clients list of coaches
     * that train them.
     *
     * @param c The new coach to be added
     */
    public void addCoach(Coach c) {
        this.coaches.add(c);
        c.getClients().add(this);
    }

    /**
     * Removes the given coach from the list of the clients coaches
     * and updates the coaches client list to remove the client.
     *
     * @param c The Coach to be removed from the clients coaches list
     */
    public void removeCoach(Coach c) {
        try {
            this.coaches.remove(c);
            c.getClients().remove(this);
        } catch (Exception e) {
            logger.error("Error removing coach from clients' coach list: {}", e.getMessage());
        }
    }
}
