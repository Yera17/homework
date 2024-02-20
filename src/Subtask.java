public class Subtask  extends Task{
    private Epic epic;
    public Subtask(String name, String description) {
        super(name, description);
        this.id = uniqueId++;
        this.status = CurrentStatus.NEW;
        this.taskType = TaskType.SUBTASK;
    }
}
