package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

//@Getter @Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="task_seq")
    @SequenceGenerator(name="task_seq",
            sequenceName="SEQ_TASK", allocationSize=50)
    private Long id;

    @Column(columnDefinition = "text")
    private String title;

    @Column(columnDefinition = "text")
    private String tag;

    @Column(columnDefinition = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
