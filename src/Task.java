import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Task {
    public int id;
    public String name;
    public String description;
    public LocalDateTime date_start;
    public LocalDateTime date_end;
    public User user_ass;
    public List<User>users = new ArrayList<User>();
    
    public void changeTaskName(String newName){
        this.name = newName;
    }
    public void changeTaskDescription(String newDescription){
        this.description = newDescription;
    }

    
    

}