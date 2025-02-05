package src;

import java.util.List;

public class TaskService {

    private List<Task> taskList;


    public TaskService(String path) { taskList = null; }

    public List<Task> getTasks(){
        return taskList;
    }

    public void setTaskList(List<Task> tasks){
        this.taskList = tasks;
    }

    public String addTask(String newTask){
        return "add";
    }

    public String updateTask(String taskToUpdate){
        return "update";
    }

    public String deleteTask(String taskToDelete){
        return "delete";
    }

    public String markProgressTask(String taskInProgress){
        return "progress";
    }

    public String markDoneTask(String taskDone){
        return "done";
    }
    
}
