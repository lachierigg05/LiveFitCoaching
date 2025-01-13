package com.example.riggfittraining.Entities.User;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Entity
@Table(name="coaches")
public class Coach extends User {
    private static final Logger logger = LoggerFactory.getLogger(Coach.class);

    public Coach() {};

    public Coach(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password);
        this.clients = new ArrayList<>();
    }

    /**
     * Represents a coaches list of clients
     * where a coach can have multiple clients
     */
    @ManyToMany
    private ArrayList<Client> clients;

    /**
     * Retrieves the list of the coaches clients.
     *
     * @return List of the coaches clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * Removes a client from the coaches client list
     * and updates the clients coach list if the client.
     *
     * @param c The client to be removed
     */
    public void removeClient(Client c) {
        try {
            clients.remove(c);
            c.getCoaches().remove(this);
        } catch(Exception e) {
            logger.error("Error removing client from client list: {}", e.getMessage());
        }
    }

}
