package pl.pk99.taskmanager.data;

import org.springframework.data.repository.CrudRepository;
import pl.pk99.taskmanager.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
