package uni.ami.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.model.Task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitleEquals(String title);
    Task findByDescriptionEquals(String description);
    Task findByUser_idEquals(Long user_id);
    List<Task> findAllByStatusEquals(Boolean status);
    List<Task> findAllByCompletionDateEquals(LocalDate completionDate);
    List<Task> findAllByUserIdEquals(Long user_id);
//    List<Task> findTasksByTaskCategoryEquals(Set<Category> taskCategory);
}
