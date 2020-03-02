package pl.pk99.taskmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pk99.taskmanager.Task;
import pl.pk99.taskmanager.data.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/task")
@Controller
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("")
    public String task (Model model) {
        List<Task> taskList = new ArrayList<Task>();
        taskRepository.findAll().forEach(taskList::add);

        model.addAttribute("taskList", taskList);
        return "task";
    }

    @GetMapping("/{id}")
    public String taskWithId (@PathVariable int id, Model model) {
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(taskRepository.findById(id).get());

        model.addAttribute("taskList", taskList);
        return "task";
    }

    @GetMapping("/create")
    public String createTask (Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/create")
    public String postTask (@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/task/" + taskRepository.count();
    }


}
