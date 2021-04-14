package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task extends AuditModel {

//    public Task(){}

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

//    @Column(columnDefinition = "int")
//    private Tag tag;

    @ManyToMany
    @JoinTable(
            name = "task_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    Set<Category> taskCategory;

    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
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
