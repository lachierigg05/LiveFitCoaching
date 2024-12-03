package main.java.com.lachierigg.livefit.livefit_coaching.User;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int user_id; 
    private String name;
    private String email;

    public User(int user_id, String name, String email) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
    }

    // User ID methods 
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    // Name methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Email methods
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
