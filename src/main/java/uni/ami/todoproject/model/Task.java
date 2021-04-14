package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task extends AuditModel {

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
    private Date completionDate;

    @Column(columnDefinition = "boolean")
    private Boolean status;

    @ManyToMany
    @JoinTable(
            name = "task_category",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    Set<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
