package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task extends AuditModel {

    public Task(Long id, String title, String description, LocalDate completionDate, Boolean status, Set<Category> taskCategory, Set<Tag> tags, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completionDate = completionDate;
        this.status = status;
        this.taskCategory = taskCategory;
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

    //    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Tag> tags;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private User user;

//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
////    public List<Tag> getTag() {
////        return tags;
////    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
////    public void setTag(List<Tag> tags) {
////        this.tags = tags;
////    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
////                ", tag='" + tags + '\'' +
//                ", description='" + description + '\'' +
//                ", user=" + user +
//                '}';
//    }
}
