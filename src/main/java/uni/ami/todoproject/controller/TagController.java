package uni.ami.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.ami.todoproject.model.Tag;
import uni.ami.todoproject.serviceImpl.TagServiceImpl;

import javax.validation.Valid;

@RestController
public class TagController {

    @Autowired
    TagServiceImpl tagService;

    @GetMapping("/tags")
    public Page<Tag> getAllTags(Pageable pageable) {
        return tagService.getAll(pageable);
    }

    @PostMapping("/tags")
    public Tag createTag(@Valid @RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping("/tags/{tagId}")
    public Tag updateTag(@Valid @PathVariable Long tagId,
                         @Valid @RequestBody Tag tag) {
        return tagService.update(tagId, tag);
    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity<?> removeTag(@Valid @PathVariable Long tagId) {
        return tagService.delete(tagId);
    }
}
