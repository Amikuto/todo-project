package uni.ami.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.ami.todoproject.model.User;
import uni.ami.todoproject.serviceImpl.UserServiceImpl;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/users")
    public Page<User> getAllUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId,
                           @Valid @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }
}
