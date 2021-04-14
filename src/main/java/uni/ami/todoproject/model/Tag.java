package uni.ami.todoproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "tags")
public class Tag extends AuditModel {

    public Tag(){}

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="tag_seq")
    @SequenceGenerator(name="tag_seq",
            sequenceName="SEQ_TAG", allocationSize=20)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "int")
    private Integer color;

//    @ManyToOne(fetch = FetchType.LAZY)
////    @MapsId
//    @OnDelete(action = OnDeleteAction.CASCADE)
////    @JoinColumn(name = "tags")
//    @JsonIgnore
//    private Task task;

    @ManyToMany(mappedBy = "tags")
    Set<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

//    public Long getId() {
//        return id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public Integer getColor() {
//        return color;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Task getTask() {
//        return task;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setColor(Integer color) {
//        this.color = color;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
//    }
//
//    @Override
//    public String toString() {
//        return "Tag{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", color=" + color +
//                ", task=" + task +
//                ", user=" + user +
//                '}';
//    }
}
