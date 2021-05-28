package uni.ami.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.ami.todoproject.model.Category;
import uni.ami.todoproject.serviceImpl.CategoryServiceImpl;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public Page<Category> getAllCategories(Pageable pageable){
        return categoryService.getAll(pageable);
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@Valid @PathVariable Long categoryId,
                                   @Valid @RequestBody Category category) {
        return categoryService.update(categoryId, category);
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<?> removeCategory(@Valid @PathVariable Long categoryId) {
        return categoryService.delete(categoryId);
    }
}
