import java.util.List;

public interface Manager {
    List<Task> getAll();

    Task getById(int id);

    void createTask(Task task);
    void createSubtask(Subtask subtask);
    void createEpic(Epic epic);


}
