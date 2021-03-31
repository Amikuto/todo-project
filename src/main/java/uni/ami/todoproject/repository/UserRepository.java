package uni.ami.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.ami.todoproject.model.Task;
import uni.ami.todoproject.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByNameEquals(String name);
    List<User> findAllBySurnameEquals(String surname);
    List<User> findAllBySurnameAndNameAndPatronymicEquals(String surname, String name, String patronymic);
    User findByTasksIdEquals(Long tasks_id);
//    List<User> findUserByTasksEquals(List<Task> tasks);
}
