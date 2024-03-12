
public class Task {
    protected String name;
    protected String description;
    protected int id;
    protected CurrentStatus status;
    protected static int uniqueId = 1;
    protected TaskType taskType;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = uniqueId++;
        this.status = CurrentStatus.NEW;
        this.taskType = TaskType.TASK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public CurrentStatus getStatus() {
        return status;
    }

    public void setStatus(CurrentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
