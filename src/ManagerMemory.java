import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMemory implements Manager{
    private final List<Task> tasks = new ArrayList<>();
    private final List<Epic> epics = new ArrayList<>();
    private final List<Subtask> subtasks = new ArrayList<>();
    private final List<Task> history = new ArrayList<>();

    @Override
    public List<Task> getAll() {
        List<Task> allTasks = new ArrayList<>(tasks);
        allTasks.addAll(subtasks);
        allTasks.addAll(epics);
//        updateHistory(allTasks);
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
        List<Task> allTasks = getAll();
        int counter = 0;
        for (Task allTask : allTasks) {
            if (allTask.getId() == id) {
                counter = 1;
                if (allTask.taskType == TaskType.TASK) {
                    tasks.remove(allTask);
                } else if (allTask.taskType == TaskType.SUBTASK) {
                    subtasks.remove(allTask);
                } else {
                    epics.remove(allTask);
                }
            }
        }
        if (counter == 0) {
            throw new NotFoundException();
        }
    }


    @Override
    public Task getById(int id) throws NotFoundException {
        List<Task> allTasks = getAll();
        int counter = 0;
        for (Task allTask : allTasks) {
            if (allTask.getId() == id) {
                counter = 1;
                updateHistory(allTask);
                return allTask;
            }
        }
        if (counter == 0) {
            throw new NotFoundException();
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
    @Override
    public List<Task> getHistory() {
        return history;
    }
    public void updateHistory(Task task) {
        if (history.size() == 10) {
                history.remove(0);
            history.add(task);
        } else if (1 + history.size() <= 10) {
            history.add(task);
        }
    }
    public void updateHistory(List<Task> tasks) {
        if (history.size() == 10) {
            for (int i = 0; i < tasks.size(); i++) {
                history.removeFirst();
            }
            history.addAll(tasks);
        } else if (tasks.size() + history.size() <= 10) {
            history.addAll(tasks);
        }
    }
}
