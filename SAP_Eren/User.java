package SAP_Eren;

import java.io.Serializable;

enum UserRole {
    ADMIN,
    USER
}

public class User implements Serializable {
    private String username;
    private String password;
    private UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password + ", Role: " + role;
    }
}