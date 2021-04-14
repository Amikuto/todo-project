package uni.ami.todoproject.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.ami.todoproject.repository.TaskRepository;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/task")
    public ResponseEntity<?> getTask(){
        System.out.println(taskRepository.findByUser_idEquals(1L).getTitle());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
