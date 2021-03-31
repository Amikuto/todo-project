package uni.ami.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.model.Task;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByNameEquals(String name);
//    List<Category> findCategoriesByTasksEquals(Set<Task> tasks);
}
