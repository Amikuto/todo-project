package uni.ami.todoproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "category")
public class Category extends AuditModel {

    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="category_seq"
    )
    @SequenceGenerator(
            name="category_seq",
            sequenceName="SEQ_CATEGORY",
            allocationSize=20,
            initialValue = 10
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @ManyToMany(mappedBy = "categories")
    Set<Task> tasks;
}
