import java.util.ArrayList;
import java.util.List;

public class Epic extends Task{
    private List<Task> subtasks = new ArrayList<>();


    public Epic(String name, String description) {
        super(name, description);
        this.id = uniqueId++;
        this.taskType = TaskType.EPIC;
        int counterNEW = 0;
        int counterDONE = 0;
        for (int i = 0; i < subtasks.size(); i++) {
            if (subtasks.get(i).getStatus() == CurrentStatus.NEW) {
                counterNEW++;
            }
            if (subtasks.get(i).getStatus() == CurrentStatus.DONE) {
                counterDONE++;
            }
        }
        if (counterNEW == subtasks.size()) {
            this.status = CurrentStatus.NEW;
        } else if (counterDONE == subtasks.size()) {
          this.status = CurrentStatus.DONE;
        } else {
            this.status = CurrentStatus.IN_PROGRESS;
        }

    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Task> subtasks) {
        this.subtasks = subtasks;
    }
}
