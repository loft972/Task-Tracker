package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        
        if(args[0].equals("add")){
            Task t = new Task(args[1]);
            System.out.println(t);

            File file = new File("../resources/taskList.json");
        
        try{
            if(file.createNewFile()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("{ \"TaskList\" : \t\t\n [\t\t\t\n {\"id\" :\""+ t.getId() + 
                 "\", \"description\" : \"" + t.getDescription() +
                 "\", \"status\" : \"" + t.getStatus()+
                  "\", \"createdAt\" : \""+ t.getCreatedAt() + 
                  "\", \"updatedAt\" : \""+ t.getUpdatedAt() + "\"} \t\t\n] \t\t\t\n}");
                writer.close();
            } else {
                System.out.println("File aldready exists");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        }

        
        
    }
}