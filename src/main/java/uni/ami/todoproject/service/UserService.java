package uni.ami.todoproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    ResponseEntity<?> delete(Long id);

    User update(Long id, User user);

    User getUserById(Long id);

    Page<User> getAll(Pageable pageable);

    User findUserByEmail(String email);

    User findUserByPassword(Integer password);

    User getUserByTaskId(Long id);

    List<Task> findAllTasksByUserId(Long id);
}
