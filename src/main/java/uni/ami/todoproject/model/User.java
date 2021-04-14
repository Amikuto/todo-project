package uni.ami.todoproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User extends AuditModel {

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
    private Set<Task> tasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Tag> tags;
}
