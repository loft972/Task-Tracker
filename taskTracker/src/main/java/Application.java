import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        TaskService taskService = new TaskService();
        switch (args[0]){
            case "add" -> taskService.addTask(args[1]);
            case "update" -> taskService.updateTask(Integer.parseInt(args[1]), args[2]);
            case "delete" -> taskService.delete(Integer.parseInt(args[1]));
            case "mark-in-progress" -> taskService.markTask(Integer.parseInt(args[1]), Status.IN_PROGRESS);
            case "mark-done" -> taskService.markTask(Integer.parseInt(args[1]), Status.DONE);
            case "list" -> System.out.println("list");
        }
    }
}
