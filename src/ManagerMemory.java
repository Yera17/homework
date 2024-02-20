import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMemory implements Manager{
    Scanner scanner = new Scanner(System.in);
    List<Task> tasks = new ArrayList<>();
    List<Epic> epics = new ArrayList<>();
    List<Subtask> subtasks = new ArrayList<>();

    @Override
    public List<Task> getAll() {
        List<Task> allTasks = tasks;
        allTasks.addAll(subtasks);
        allTasks.addAll(epics);
        return allTasks;
    }

    @Override
    public Task getById(int id) {
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getId() == id) {
                return getAll().get(i);
            }
        }
        return null;
    }

    @Override
    public void createTask(Task task) {
        tasks.add(task);
    }
    @Override
    public void createSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }
    @Override
    public void createEpic(Epic epic) {
        epics.add(epic);
    }
}
