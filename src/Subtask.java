public class Subtask  extends Task{
    private Epic epic;
    public Subtask(String name, String description, Epic epic) {
        super(name, description);
        this.taskType = TaskType.SUBTASK;
        this.epic = epic;
        epic.addSubtask(this);
    }

    @Override
    public void setStatus(CurrentStatus status) {
        this.status = status;
        epic.updateStatus();
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name=" + name +
                ", epic='" + epic + '\'' +
                '}';
    }
}
