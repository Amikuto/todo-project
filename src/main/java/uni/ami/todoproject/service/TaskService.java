package uni.ami.todoproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.model.User;

import java.util.Date;
import java.util.List;

public interface TaskService {

    Task save(Task task);

    ResponseEntity<?> delete(Long id);

    Task update(Long id, Task task);

    Task getById(Long id);

    Page<Task> getAll(Pageable pageable);

    Task getByTitle(String title);

    Task getByDescription(String description);

    List<Task> getAllByStatus(Boolean status);

    List<Task> getAllByCompDate(Date compDate);

    List<Task> getAllByUserId(Long userId);

}
