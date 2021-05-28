package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tasks")
public class Task extends AuditModel {

    public Task(Long id, String title, String description, LocalDate completionDate, Boolean status, List<Category> categories, List<Tag> tags, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completionDate = completionDate;
        this.status = status;
        this.categories = categories;
        this.tags = tags;
        this.user = user;
    }

    public Task() {
    }
	
    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="task_seq"
    )
    @SequenceGenerator(
            name="task_seq",
            sequenceName="SEQ_TASK"
    )
    private Long id;

    @Column(columnDefinition = "text", unique = true)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "date")
    private LocalDate completionDate;

    @Column(columnDefinition = "boolean")
    private Boolean status;

    @ManyToMany
    @JoinTable(
            name = "task_category",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonManagedReference
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonManagedReference
    private List<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private User user;
}
