package uni.ami.todoproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uni.ami.todoproject.exceptions.ResourceNotFoundException;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.repository.CategoryRepository;
import uni.ami.todoproject.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.delete(categoryRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category update(Long id, Category category) {
        return categoryRepository.findById(id)
                .map(category_temp -> {
                    category_temp.setName(category.getName());

                    return categoryRepository.save(category_temp);
                }).orElseThrow(new ResourceNotFoundException("Категории с заданным id не найдено"));
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(new ResourceNotFoundException("Категории с заданным id не найдено!"));
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> getAllByName(String name) {
        return categoryRepository.findAllByNameEquals(name);
    }
}
