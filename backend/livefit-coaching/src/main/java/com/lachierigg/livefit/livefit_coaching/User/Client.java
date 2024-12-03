package main.java.com.lachierigg.livefit.livefit_coaching.User;

public class Client extends User {
    private Coach coach;

    public Client(int user_id, String name, String email, Coach coach) {
        super(user_id, name, email);
        this.coach = coach;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    
}
