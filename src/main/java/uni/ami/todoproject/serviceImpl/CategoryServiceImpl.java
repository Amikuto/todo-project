package uni.ami.todoproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.repository.CategoryRepository;
import uni.ami.todoproject.service.CategoryService;

import java.util.List;

@Repository
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public Category update(Long id, Category category) {
        return null;
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Category> getAllByName(String name) {
        return null;
    }
}
