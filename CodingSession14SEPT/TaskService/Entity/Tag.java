package CodingSession14SEPT.TaskService.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<CodingSession14SEPT.TaskService.Entity.TaskModel1> tasks;
    public Tag(Tag tagName) {
        this.name = name;
    }
}
