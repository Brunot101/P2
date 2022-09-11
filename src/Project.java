

import java.time.LocalDateTime;
import java.util.*;

public class Project {
    public int id;
    public String name;
    public String description;
    public String status;
    public LocalDateTime date_start;
    public LocalDateTime date_end;
    public List<User>users = new ArrayList<User>();
    public List<Task>tasks = new ArrayList<Task>();
    public String time;
    public String money;

    public void changeProjectName(String newName){
        this.name = newName;
    }
    public void changeProjectDescription(String newDescription){
        this.description = newDescription;
    }
    public void changeProjectMoney(String newMoney){
        this.money = newMoney;
    }
    
}