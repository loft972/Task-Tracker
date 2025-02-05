package src;

public class Application {

    public static void main(String[] args) {

        TaskService taskService = new TaskService();

        switch (args[0]) {
            case "add" -> taskService.addTask(args[1]);
            case "update" -> taskService.updateTask(args[1]);
            case "delete" -> taskService.deleteTask(args[1]);
            case "mark-in-progress" -> taskService.markProgressTask(args[1]);
            case "mark-done" -> taskService.markDoneTask(args[1]);  
            default -> System.out.println("You have entered an unknown order");
        }

    }
}