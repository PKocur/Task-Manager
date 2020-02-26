package pl.pk99.taskmanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pk99.taskmanager.Task;

@RequestMapping("/task")
@Controller
public class TaskController {

    @GetMapping("/")
    public String task () {
        return "task";
    }

    @GetMapping("/{id}")
    public String taskWithId (@PathVariable int id) {
        return "task";
    }

    @GetMapping("/create")
    public String createTask (Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/create")
    public String postTask (@ModelAttribute Task task) {
        //TODO: Zapisz nowy task i przenieś się do niego...
        return "redirect:/";
    }


}
