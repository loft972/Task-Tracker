package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private List<Task> taskList;
    private String path;
    private boolean fileExist; //will be true if the file is successul created

    public TaskService() {
        this.path = "resources/taskList.json";
        this.fileExist = Files.exists(Paths.get(path));
        this.taskList = null;
    }

    public List<Task> getTasks(){
        return taskList;
    }

    public void setTaskList(List<Task> tasks){
        this.taskList = tasks;
    }
    
    public boolean isFileExist(){
        return fileExist;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public void addTask(String newTask) throws IOException {
        Task t = new Task(newTask);
        String taskString = t.toString();
        if(!isFileExist()){
            Files.writeString(Paths.get(path), "[" + taskString +"]" , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } else {
            String fileString = findFile(path).substring(1,findFile(path).length()-1);
            Files.writeString(Paths.get(path), "[" + fileString +  ", "+ taskString + " ]", StandardOpenOption.WRITE);
        }
    }

    public String updateTask(String taskToUpdate) {
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

    private String findFile(String path) throws IOException {
        /*Path filePath = Path.of(path);
        return Files.readString(filePath);*/
        StringBuilder content = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }

        return content.toString();
    }
 
}
