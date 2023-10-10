package CodingSession14SEPT.TaskService.TaskRespository;

import CodingSession14SEPT.TaskService.Entity.Tag;
import CodingSession14SEPT.TaskService.Entity.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);
}
