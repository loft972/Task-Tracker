import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        TaskService taskService = new TaskService();
        switch (args[0]){
            case "add" -> taskService.addTask(args[1]);
            case "update" -> System.out.println("update");
            case "delete" -> System.out.println("delete");
            case "mark-in-progress" -> System.out.println("mark-in-progress");
            case "mark-done" -> System.out.println("mark-done");
            case "list" -> System.out.println("list");
        }
    }
}
