package main.java.com.lachierigg.livefit.livefit_coaching.User;

public class Coach extends User {
    private List<Client> clients; 

    public Coach(int user_id, String name, String email) {
        super(user_id, name, email);
        this.clients = new ArrayList<Client>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void clearClients(List<Client> clients) {
        clients.clear();
    }
}
