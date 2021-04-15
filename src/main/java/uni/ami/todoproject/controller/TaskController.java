package uni.ami.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.serviceImpl.TaskServiceImpl;

import javax.validation.Valid;

@RestController
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("/tasks")
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskService.getAll(pageable);
    }

    @PostMapping("/tasks")
    public Task createTask (@Valid @RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/tasks/{taskId}")
    public Task updateTask(@Valid @PathVariable Long taskId,
                           @Valid @RequestBody Task task) {
        return taskService.update(taskId, task);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<?> removeTask(@Valid @PathVariable Long taskId) {
        return taskService.delete(taskId);
    }
}
