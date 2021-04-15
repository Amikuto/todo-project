package uni.ami.todoproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uni.ami.todoproject.exceptions.ResourceNotFoundException;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.repository.TaskRepository;
import uni.ami.todoproject.service.TaskService;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.delete(taskRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Task update(Long id, Task task) {
        return taskRepository.findById(id)
                .map(task_temp -> {
                    task_temp.setStatus(task.getStatus());
                    task_temp.setTitle(task.getTitle());
                    task_temp.setDescription(task.getDescription());
                    task_temp.setCompletionDate(task.getCompletionDate());

                    return taskRepository.save(task_temp);
                }).orElseThrow(new ResourceNotFoundException("Задания с заданным id не найдено"));
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(new ResourceNotFoundException("Задания с таким ID не найдено!"));
    }

    @Override
    public Page<Task> getAll(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Task getByTitle(String title) {
        return null;
    }

    @Override
    public Task getByDescription(String description) {
        return null;
    }

    @Override
    public List<Task> getAllByStatus(Boolean status) {
        return null;
    }

    @Override
    public List<Task> getAllByCompDate(Date compDate) {
        return null;
    }

    @Override
    public List<Task> getAllByUserId(Long userId) {
        return null;
    }

    public Task getByUserId(Long userId) {
        return taskRepository.findByUser_idEquals(userId);
    }
}
