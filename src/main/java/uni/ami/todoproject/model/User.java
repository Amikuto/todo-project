package uni.ami.todoproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


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

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private UserAccount userAccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> tasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Tag> tags;

//    public Long getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public Integer getPassword() {
//        return password;
//    }
//
//    public List<Task> getTasks() {
//        return tasks;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    //    public UserAccount getUserAccount() {
////        return userAccount;
////    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public void setPassword(Integer password) {
//        this.password = password;
//    }
//
//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    //    public void setUserAccount(UserAccount userAccount) {
////        this.userAccount = userAccount;
////    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", login='" + login + '\'' +
//                ", password=" + password +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", patronymic='" + patronymic + '\'' +
//                ", name='" + name + '\'' +
//                ", tasks=" + tasks +
//                '}';
//    }
}
