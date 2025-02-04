package src;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    private String description;
    private Status status;
    private String createdAt;
    private String updatedAt;

    public Task(){}

    public Task(String description){
        this.id = updateId();
        this.description = description;
        this.status = Status.TODO;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.createdAt = LocalDateTime.now().format(formatter);
        this.updatedAt = null;
    }

    public int getId(){ return id;};
    public void setId(int id){ this.id = id;}
    public String getDescription(){return description;}
    public void setDescription(String desc){this.description = desc;}
    public Status getStatus(){return status;}
    public void setStatus(Status status){this.status = status;}
    public String getCreatedAt(){return createdAt;}
    public void setCreatedAt(String created){this.createdAt = created;}
    public String getUpdatedAt(){return updatedAt;}
    public void setUpdatedAt(String updapted){this.updatedAt = updapted;}

    public String toString(){
        return "Task [id=" + id + ", description=" + description + ", status=" + status + ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt + "]";
    }

    private boolean isFileExist(){
        File f = new File("/resources/task.json");
        return f.exists();
    }

    private int updateId(){
        return isFileExist() ? 2 : 1;
    }

}
