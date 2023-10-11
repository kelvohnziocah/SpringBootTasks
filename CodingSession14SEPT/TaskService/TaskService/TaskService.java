package CodingSession14SEPT.TaskService.TaskService;

import CodingSession14SEPT.TaskService.Entity.TaskModel;
import CodingSession14SEPT.TaskService.Entity.TaskModel1;

import java.util.List;

public interface TaskService {
    List<TaskModel> getAllTasks();
    TaskModel createTask(TaskModel1 task);
    TaskModel getTaskById(Long id);
    TaskModel1 updateTask(Long id, TaskModel1 updatedTask);
    boolean deleteTask(Long id);
    List<TaskModel> getTasksByTagName(String tagName);

}
