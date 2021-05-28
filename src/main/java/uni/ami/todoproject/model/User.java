package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User extends AuditModel {

    public User() {
    }

    public User(Long id, String login, Integer password, String email, String name, String surname, String patronymic, List<Task> tasks, List<Tag> tags) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.tasks = tasks;
        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="user_seq")
    @SequenceGenerator(name="user_seq",
            sequenceName="SEQ_USER", allocationSize=20)
    private Long id;

    @Column(columnDefinition = "text", unique = true)
    private String login;

    @Column(columnDefinition = "int")
    private Integer password;

    @Column(columnDefinition = "text", unique = true)
    private String email;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String surname;

    @Column(columnDefinition = "text")
    private String patronymic;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Task> tasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Tag> tags;
}
