import java.util.List;

public interface Manager {
    List<Task> getAll();

    void deleteAll();
    void deleteById(int id) throws NotFoundException;

    Task getById(int id) throws NotFoundException;

    void createTask(Task task);
    void createSubtask(Subtask subtask);
    void createEpic(Epic epic);

    List<Task> getHistory();


}
