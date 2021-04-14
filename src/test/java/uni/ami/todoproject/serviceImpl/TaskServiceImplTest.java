package uni.ami.todoproject.serviceImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.model.Tag;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.model.User;
import uni.ami.todoproject.repository.TaskRepository;
import uni.ami.todoproject.repository.UserRepository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskServiceImplTest {

    private Set<Category> categories;
    private List<Tag> tags;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


    @Test
    void getByUserId() {

        User user = new User(1L, "123", 123, "123@email.com", "123", "surname", "patronymic", null, null);
        userRepository.save(user);

        Task task = new Task(1L, "title", "desc", LocalDate.now(), true, null, null, user);

        taskRepository.save(task);

        Task task1 = taskRepository.findByUser_idEquals(1L);

//        assertThat(task1.getId().);
//        System.out.println(taskRepository.findByUser_idEquals(1L));
    }
}