

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private static String path = "src/main/resources/taskList.json";
    private List<Task> tasks = new ArrayList<>();

    public TaskService() {}

    public void addTask(String description) throws IOException {
        if(new File(path).exists()){
            tasks = readJsonFile();
            System.out.println(tasks.size());
            tasks.add(new Task(tasks.size(), description));
            updateId(tasks);
        } else {
            tasks.add(new Task(description));
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path),tasks);
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
}
