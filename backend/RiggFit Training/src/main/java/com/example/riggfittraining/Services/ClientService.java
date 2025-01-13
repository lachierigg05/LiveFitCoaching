package com.example.riggfittraining.Services;

import com.example.riggfittraining.Entities.User.Client;
import com.example.riggfittraining.Entities.User.Coach;
import com.example.riggfittraining.Entities.User.User;
import com.example.riggfittraining.Repositories.ClientRepository;
import jakarta.persistence.ManyToMany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ClientService {
    private final ClientRepository clientRepo;
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    /**
     * Retrieves a list of all clients
     */
    public ArrayList<Client> getAllClients() {
        logger.info("Retrieving all clients.");
        return (ArrayList<Client>) clientRepo.findAll();
    }

    /**
     * Retrieves a client by their id
     *
     * @param id The id of the client to be retrieved
     */
    public Client getClient(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> {
            logger.error("Attempted to retrieve a client that does not exist.");
            return new IllegalArgumentException("Client " + id + " does not exist.");
        });
    }

    /**
     * Creates a new client based on the parameters given
     * by the user and adds the client to the database.
     *
     * @param firstName First name of the new client
     * @param lastName Last name of the new client
     * @param email Email of the new client
     * @param username Username of the new client
     * @param password Password of the new client
     */
    public void createClient(String firstName, String lastName, String email, String username, String password) {
        Client newClient = new Client(firstName, lastName, email, username, password);
        logger.info("New client created: {}", newClient);
        clientRepo.save(newClient);
    }

    /**
     * Deletes a given client from the database
     *
     * @param c The client to be deleted
     */
    public void deleteClient(Client c) {
        // Checks if the given client is not null
        // and thus exists.
        if (c == null) {
            logger.error("Attempted to delete a non-existent client.");
            throw new IllegalArgumentException("Cannot delete a client that doesn't exist.");
        }
        clientRepo.delete(c);
    }
}
