package uni.ami.todoproject.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
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
    @JsonBackReference
    private List<Task> tasks;
}
