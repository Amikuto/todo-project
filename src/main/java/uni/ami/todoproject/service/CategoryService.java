package uni.ami.todoproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.model.Task;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    ResponseEntity<?> delete(Long id);

    Category update(Long id, Category category);

    Category getById(Long id);

    Page<Category> getAll(Pageable pageable);

    List<Category> getAllByName(String name);
}
