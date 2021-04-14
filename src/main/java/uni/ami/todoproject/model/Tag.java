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

    @ManyToMany(mappedBy = "tags")
    Set<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
