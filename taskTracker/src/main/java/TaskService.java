

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private static String path = "src/main/resources/taskList.json";
    private List<Task> tasks = new ArrayList<>();

    public TaskService() { /* TODO document why this constructor is empty */ }

    public void addTask(String description) throws IOException {
        if(new File(path).exists()){
            tasks = readJsonFile();
            tasks.add(new Task(tasks.size(), description));
            updateId(tasks);
        } else {
            tasks.add(new Task(description));
        }

        writeIntoJsonFile(path, tasks);
    }

    private List<Task> readJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), new TypeReference<List<Task>>(){});

    }

    private void updateId(List<Task> taskList) throws IOException {
        int i =1;
        for(Task t : taskList){
            t.setId(i);
            i++;
        }
    }

    private void writeIntoJsonFile(String path, List<Task> taskList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path),taskList);
    }

    public void updateTask(int id, String description) throws IOException {
        tasks = readJsonFile();
        Task taskUpdate = findTask(id, tasks);
        if(taskUpdate != null){
            taskUpdate.setDescription(description);
            taskUpdate.setUpdatedAt();
            tasks.set(tasks.indexOf(taskUpdate), taskUpdate);
            writeIntoJsonFile(path, tasks);
        }
    }

    public void delete(int id) throws IOException {
        tasks = readJsonFile();
        Task taskToDelete = findTask(id, tasks);
        if(taskToDelete != null){
            tasks.remove(taskToDelete);
            writeIntoJsonFile(path, tasks);
        }
    }

    private Task findTask(int id, List<Task>taskList){
        return taskList.stream()
                .filter(task -> task.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void markTask(int id, Status status) throws IOException {
        tasks = readJsonFile();
        Task taskToMark = findTask(id, tasks);
        if(taskToMark != null){
            taskToMark.setStatus(status);
            tasks.set(tasks.indexOf(taskToMark), taskToMark);
            writeIntoJsonFile(path, tasks);
        }
    }

    public void listTask(String action) throws IOException {
        tasks = readJsonFile();
        List<Task> taskList = new ArrayList<>();
        switch (action){
            case "" -> { taskList = tasks; }
            case "done" -> { taskList =tasks.stream().filter(task -> task.getStatus() == Status.DONE).toList(); }
            case "todo" -> { taskList = tasks.stream().filter(task -> task.getStatus() == Status.TODO).toList(); }
            case "in-progress" -> { taskList = tasks.stream().filter(task -> task.getStatus() == Status.IN_PROGRESS).toList(); }
        }
        System.out.println(taskList);
    }

}
