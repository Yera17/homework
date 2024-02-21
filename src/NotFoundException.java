public class NotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Task with the following ID was not found";
    }
}
