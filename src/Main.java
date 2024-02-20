public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerMemory();
        Task task = new Task("sdf", "sdf");
        Subtask subtask = new Subtask("", "");
        Epic epic = new Epic("", "");
        
        manager.createTask(task);
        manager.createSubtask(subtask);
        manager.createEpic(epic);


        System.out.println(manager.getAll());
        System.out.println(manager.getById(1));

    }
}