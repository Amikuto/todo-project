package uni.ami.todoproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uni.ami.todoproject.exceptions.ResourceNotFoundException;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.model.User;
import uni.ami.todoproject.repository.TaskRepository;
import uni.ami.todoproject.repository.UserRepository;
import uni.ami.todoproject.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.delete(userRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.findById(id)
                .map(user_temp -> {
                    user_temp.setLogin(user.getLogin());
                    user_temp.setPassword(user.getPassword());
                    user_temp.setEmail(user.getEmail());
                    user_temp.setName(user.getName());
                    user_temp.setPatronymic(user.getPatronymic());
                    user_temp.setSurname(user.getSurname());

//                    user_temp.setTasks(user.getTasks());

                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("Пользователь с указанным ID не найден!"));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Пользователь с указанным ID не найден!"));
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByPassword(Integer password) {
        return null;
    }

    @Override
    public User getUserByTaskId(Long id) {
        return null;
    }

    @Override
    public List<Task> findAllTasksByUserId(Long id) {
        return null;
    }
}
