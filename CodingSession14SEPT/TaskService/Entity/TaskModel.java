package CodingSession14SEPT.TaskService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class TaskModel {
    @Id
    private Long id;
    private String taskTitle;
    private String description;
    private int quantity;
    private String createdBy;
    private String updatedBy;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    @ManyToMany
    @JoinTable(name = "task_tag",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
}
