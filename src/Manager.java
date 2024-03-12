import java.util.List;
import java.util.Map;

public interface Manager {
    Map<Integer, Task> getAll();

    void deleteAll();
    void deleteById(int id) throws NotFoundException;

    Task getById(int id) throws NotFoundException;

    void createTask(Task task);
    void createSubtask(Subtask subtask);
    void createEpic(Epic epic);

    Map<Integer, Task> getHistory();


}
