package uni.ami.todoproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import uni.ami.todoproject.model.Tag;

public interface TagService {

    Tag save(Tag tag);

    ResponseEntity<?> delete(Long id);

    Tag update(Long id, Tag tag);

    Page<Tag> getAll(Pageable pageable);
}
