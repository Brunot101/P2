import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Task extends Project {
    
    public User user_resp;
    public List<User>users = new ArrayList<User>();
    public String project;
    

    public Task(int id, String name, String description,DateRange date, String project){
        super(id, name, description, date, null);
        this.project = project;
        // this.id = id;
        // this.name = name;
        // this.description = description;
        // LocalDateTime ex = LocalDateTime.parse(date_start);
        // this.date_start = ex;
        // ex = LocalDateTime.parse(date_end);
        // this.date_end = ex;


    }
    @Override 
    public void showInfo() {
        
        System.out.printf("%5s %20s %20s %20s %20s  ", "ID", "NAME",  "DATE START", "DATE END", "PROJECT");
                    System.out.println();
                    System.out.printf("%5s %20s %20s  %20s %20s ", getId(), getName(),date.showDateStart()  , date.showDateEnd(), this.project);
                    System.out.println();
                    System.out.printf("Description:");
                    System.out.println();
                    System.out.printf(getDescription());
                    System.out.println();
                    if(user_resp!= null){

                        System.out.printf("Resp: " + this.user_resp);
                    }
                    System.out.println();
                    System.out.println("Team: ");
                    for(User user : this.users){
                        System.out.println(user.getName());
                    }
                    
    }
    

    // public int getId(){
    //     return this.id;
    // }

    // public String getName(){
    //     return this.name;
    // }

    // public String getDescription(){
    //     return this.description;
    // }
    // public LocalDateTime getDateStart(){
    //     return this.date_start;
    // }
    // public LocalDateTime getDateEnd(){
    //     return this.date_end;
    // }

    // public void setTaskName(String newName){
    //     this.name = newName;
    // }
    // public void setTaskDescription(String newDescription){
    //     this.description = newDescription;
    // }

    // public void setDateStart(String dateTimeStart){
    //     LocalDateTime ex = LocalDateTime.parse(dateTimeStart);
    //     this.date_start = ex;

    // }

    // public void setDateEnd(String dateTimeEnd){
    //     LocalDateTime ex = LocalDateTime.parse(dateTimeEnd);
    //     this.date_end = ex;

    // }

    // public String showDateStart(){
        
    //     return this.date_start.toString();
    // }

    // public String showDateEnd(){
        
    //     return this.date_end.toString();
    // }
    

}