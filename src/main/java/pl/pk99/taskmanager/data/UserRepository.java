package pl.pk99.taskmanager.data;

import org.springframework.data.repository.CrudRepository;
import pl.pk99.taskmanager.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
