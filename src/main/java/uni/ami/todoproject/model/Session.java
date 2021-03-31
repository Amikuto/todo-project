package uni.ami.todoproject.model;

import javax.persistence.*;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
                    generator="session_seq")
    @SequenceGenerator(name="session_seq",
                       sequenceName="SEQ_SESSION", allocationSize=20)
    private Long id;

    public Long getId() {
        return id;
    }
}