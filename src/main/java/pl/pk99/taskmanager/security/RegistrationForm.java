package pl.pk99.taskmanager.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import pl.pk99.taskmanager.model.User;

public class RegistrationForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password));
    }
}
