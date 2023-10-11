package CodingSession14SEPT.TaskService.TaskService;

import CodingSession14SEPT.TaskService.Entity.Tag;
import CodingSession14SEPT.TaskService.Entity.TaskModel1;
import CodingSession14SEPT.TaskService.TaskRespository.TagRepository;
import CodingSession14SEPT.TaskService.TaskRespository.TaskRepository;
import com.example.Items.Service.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TagService(TagRepository tagRepository, TaskRepository taskRepository) {
        this.tagRepository = tagRepository;
        this.taskRepository = taskRepository;
    }

    public List<Tag> getTagsForItem(Long taskId) {
        Optional<TaskModel1> task = Optional.ofNullable(taskRepository.getTaskById(taskId));
        if (task.isPresent()) {
            return task.get().getTags();
        } else {
            throw new ItemNotFoundException("Item not found with id " + taskId);
        }
    }
    public Tag createTag(Tag tag){
            Tag existingTag = tagRepository.findByName(tag.getName());
            if (existingTag != null) {
                return existingTag;
            }
            return tagRepository.save(tag);
    }
    public Tag findTagByName(String name) {
        return tagRepository.findByName(name);
    }
}
