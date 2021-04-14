package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users_account")
public class UserAccount extends AuditModel{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="user_acc_seq")
    @SequenceGenerator(name="user_acc_seq",
            sequenceName="SEQ_USER_ACC", allocationSize=20)
    private Long id;

    @Column(columnDefinition = "text")
    private String fullName;

    @Column(columnDefinition = "int8")
    private Long avatar;

    @Column(columnDefinition = "date")
    private String birthDate;

    @Column(columnDefinition = "text")
    private String selfDescription;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id")
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
//    public Long getAvatar() {
//        return avatar;
//    }
//
//    public String getBirthDate() {
//        return birthDate;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public String getSelfDescription() {
//        return selfDescription;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public void setAvatar(Long avatar) {
//        this.avatar = avatar;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setSelfDescription(String selfDescription) {
//        this.selfDescription = selfDescription;
//    }
//
//    @Override
//    public String toString() {
//        return "UserAccount{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", avatar=" + avatar +
//                ", birthDate='" + birthDate + '\'' +
//                ", selfDescription='" + selfDescription + '\'' +
//                ", user=" + user +
//                '}';
//    }
}
