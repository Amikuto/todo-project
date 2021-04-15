package uni.ami.todoproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uni.ami.todoproject.exceptions.ResourceNotFoundException;
import uni.ami.todoproject.model.Tag;
import uni.ami.todoproject.repository.TagRepository;
import uni.ami.todoproject.service.TagService;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (tagRepository.findById(id).isPresent()) {
            tagRepository.delete(tagRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Tag update(Long id, Tag tag) {
        return tagRepository.findById(id)
                .map(tag_temp -> {
                    tag_temp.setName(tag.getName());
                    tag_temp.setColor(tag.getColor());

                    return tagRepository.save(tag_temp);
                }).orElseThrow(new ResourceNotFoundException("Тэга с заданным id не найдено!"));
    }

    @Override
    public Page<Tag> getAll(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }
}
