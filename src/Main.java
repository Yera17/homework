public class Main {
    public static void main(String[] args) throws NotFoundException {
        Manager manager = new ManagerMemory();
        Task task = new Task("sdf", "sdf");
        Epic epic = new Epic("", "");
        Subtask subtask = new Subtask("", "", epic);
        
        manager.createTask(task);
        manager.createSubtask(subtask);
        manager.createEpic(epic);

//        manager.deleteAll();
//        manager.deleteById(3);

//        System.out.println(manager.getAll())
        System.out.println(manager.getById(1));
        System.out.println(manager.getById(1));
        System.out.println(manager.getById(1));
        System.out.println(manager.getById(3));
        System.out.println(manager.getById(1));
        System.out.println(manager.getById(3));
        System.out.println(manager.getById(1));
//        System.out.println(manager.getAll());
        System.out.println(manager.getById(2));
        System.out.println(manager.getById(3));
        System.out.println(manager.getById(1));
        System.out.println(manager.getById(3));
        System.out.println(manager.getById(1));
        System.out.println(manager.getById(2));
        System.out.println(manager.getHistory());
        System.out.println(manager.getHistory().size());

    }
}