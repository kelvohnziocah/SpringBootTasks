package CodingSession14SEPT.TaskService.TaskController;

import CodingSession14SEPT.TaskService.Entity.Tag;
import CodingSession14SEPT.TaskService.TaskService.TagService;
import CodingSession14SEPT.TaskService.TaskService.TaskServiceImplementation;
import com.example.Items.Service.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;
    public TagController (TagService tagService){
        this.tagService = tagService;
    }
    @GetMapping("/tags/task/{taskId}")
    public ResponseEntity<List<Tag>> getTagsByItemId(@PathVariable Long taskId) {
        try {
            List<Tag> tags = tagService.getTagsForItem(taskId);
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/tags")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.createTag(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTag);
    }
    @GetMapping("/tags/{name}")
    public ResponseEntity<Tag> getTagByName(@PathVariable("name") String name) {
        Tag tag = tagService.findTagByName(name);
        if (tag != null) {
            return ResponseEntity.ok(tag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
