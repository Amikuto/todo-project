package uni.ami.todoproject.model;

import javax.persistence.*;
import java.util.List;


//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private UserAccount userAccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public Integer getPassword() {
        return password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ", userAccount=" + userAccount +
                ", tasks=" + tasks +
                '}';
    }
}
