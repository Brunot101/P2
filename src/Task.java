import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDateTime date_start;
    private LocalDateTime date_end;
    public User user_ass;
    public List<User>users = new ArrayList<User>();
    

    public Task(int id, String name, String description, String date_start, String date_end){
        this.id = id;
        this.name = name;
        this.description = description;
        LocalDateTime ex = LocalDateTime.parse(date_start);
        this.date_start = ex;
        ex = LocalDateTime.parse(date_end);
        this.date_end = ex;

    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
    public LocalDateTime getDateStart(){
        return this.date_start;
    }
    public LocalDateTime getDateEnd(){
        return this.date_end;
    }

    public void setTaskName(String newName){
        this.name = newName;
    }
    public void setTaskDescription(String newDescription){
        this.description = newDescription;
    }

    public void setDateStart(String dateTimeStart){
        LocalDateTime ex = LocalDateTime.parse(dateTimeStart);
        this.date_start = ex;

    }

    public void setDateEnd(String dateTimeEnd){
        LocalDateTime ex = LocalDateTime.parse(dateTimeEnd);
        this.date_end = ex;

    }

    public String showDateStart(){
        
        return this.date_start.toString();
    }

    public String showDateEnd(){
        
        return this.date_end.toString();
    }
    

}