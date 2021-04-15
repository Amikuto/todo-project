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
}
