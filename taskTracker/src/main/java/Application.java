public class Application {

    public static void main(String[] args) {

        switch (args[0]){
            case "add" -> System.out.println("add");
            case "update" -> System.out.println("update");
            case "delete" -> System.out.println("delete");
            case "mark-in-progress" -> System.out.println("mark-in-progress");
            case "mark-done" -> System.out.println("mark-done");
            case "list" -> System.out.println("list");
        }
    }
}
