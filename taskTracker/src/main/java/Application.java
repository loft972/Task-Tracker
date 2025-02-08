import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        TaskService taskService = new TaskService();
        switch (args[0]){
            case "add" -> taskService.addTask(args[1]);
            case "update" -> taskService.updateTask(Integer.parseInt(args[1]), args[2]);
            case "delete" -> taskService.delete(Integer.parseInt(args[1]));
            case "mark-in-progress" -> System.out.println("mark-in-progress");
            case "mark-done" -> System.out.println("mark-done");
            case "list" -> System.out.println("list");
        }
    }
}
