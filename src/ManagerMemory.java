import java.util.*;

public class ManagerMemory implements Manager{
    private final Map<Integer, Task> tasks = new LinkedHashMap<>();
    private final Map<Integer, Epic> epics = new LinkedHashMap<>();
    private final Map<Integer, Subtask> subtasks = new LinkedHashMap<>();
    private final Map<Integer, Task> history = new LinkedHashMap<>();

    @Override
    public Map<Integer, Task> getAll() {
        Map<Integer, Task> allTasks = new LinkedHashMap<>(tasks);
        allTasks.putAll(subtasks);
        allTasks.putAll(epics);
        return allTasks;
    }

    @Override
    public void deleteAll() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    @Override
    public void deleteById(int id) throws NotFoundException {
        Map<Integer, Task> allTasks = getAll();
            switch (allTasks.get(id).taskType) {
                case TASK -> tasks.remove(id);
                case SUBTASK -> subtasks.remove(id);
                case EPIC -> epics.remove(id);
            }
    }


    @Override
    public Task getById(int id) throws NotFoundException {
        Map<Integer, Task> allTasks = getAll();
        updateHistory(allTasks.get(id));
        return allTasks.get(id);
    }

    @Override
    public void createTask(Task task) {
        tasks.put(task.id, task);
    }
    @Override
    public void createSubtask(Subtask subtask) {
        subtasks.put(subtask.id, subtask);
    }
    @Override
    public void createEpic(Epic epic) {
        epics.put(epic.id, epic);
    }
    @Override
    public Map<Integer, Task> getHistory() {
        return history;
    }
    public void updateHistory(Task task) {
        if (history.size() == 10) {
//                history.;
//            history.put(task.id,task);
        } else if (1 + history.size() <= 10) {
            history.put(task.id, task);
        }
    }
}
