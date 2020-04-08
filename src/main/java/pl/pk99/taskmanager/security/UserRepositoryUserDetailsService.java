package pl.pk99.taskmanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.pk99.taskmanager.data.UserRepository;
import pl.pk99.taskmanager.model.User;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userReposiotry) {
        this.userRepository = userReposiotry;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
