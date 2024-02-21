import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Epic extends Task{
    private List<Subtask> subtasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }
    public void addSubtask(Subtask subtask){
        subtasks.add(subtask);
    }

    public void updateStatus() {
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

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Epic{" +
                "name='" + name + '\'' +
                ", subtasks=[");

        Iterator<Subtask> iterator = subtasks.iterator();
        while (iterator.hasNext()) {
            Subtask subtask = iterator.next();
            builder.append("{name=\"%s\"}".formatted(subtask.getName()));
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }

        return builder
                .append("]")
                .toString();
    }
}
