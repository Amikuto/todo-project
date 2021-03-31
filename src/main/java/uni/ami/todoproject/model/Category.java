package uni.ami.todoproject.model;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(mappedBy = "taskCategory")
    Set<Task> tasks;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
