

import java.time.LocalDateTime;
import java.util.*;

public class Project {
    private int id;
    private String name;
    private String description;
    private String status;
    private LocalDateTime date_start;
    private LocalDateTime date_end;
    public User coord;
    public List<User>users = new ArrayList<User>();
    public List<Task>tasks = new ArrayList<Task>();
    public String money_duration;
    public String money_max;
    // public String money_time;



    public Project(int id, String name, String description,  String date_start, String date_end, String money_duration){
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = "em processo de criacao";
        LocalDateTime ex = LocalDateTime.parse(date_start);
        this.date_start = ex;
        ex = LocalDateTime.parse(date_end);
        this.date_end = ex;
        this.money_duration = money_duration;
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

    public String getStatus(){
        return this.status;
    }

    public String getMoney(){
        return this.money_max;
    }

    public String getMoneyDuration(){
        return this.money_duration;
    }
    



    public void setProjectName(String newName){
        this.name = newName;
    }
    public void setProjectDescription(String newDescription){
        this.description = newDescription;
    }
    // public void setProjectMoney(String newMoney){
    //     this.money = newMoney;
    // }
    public void setDateStart(String dateTimeStart){
        LocalDateTime ex = LocalDateTime.parse(dateTimeStart);
        this.date_start = ex;
    }

    public void setDateEnd(String dateTimeEnd){
        LocalDateTime ex = LocalDateTime.parse(dateTimeEnd);
        this.date_end = ex;
    }
    
    public void changeStatus(){
        if(this.date_start != null && this.date_end != null && 
        (this.coord.getType().equalsIgnoreCase("professor")  || this.coord.getType().equalsIgnoreCase("pesquisador") )
        && !this.tasks.isEmpty() && !this.users.isEmpty() && !this.money_duration.isEmpty()
        && !this.money_max.isEmpty() ){
            if( this.status.equalsIgnoreCase( "em processo de criacao") ){
                this.status = "inciado";
            }

            else if(this.status.equalsIgnoreCase("inciado") && this.date_start.isAfter(LocalDateTime.now()) ){
                this.status = "em andamento";

            }
            else if(this.status.equalsIgnoreCase("em andamento") ){
                this.status = "concluido";

            }

        }
    }

    public String showDateStart(){
        
        return this.date_start.toString();
    }

    public String showDateEnd(){
        
        return this.date_end.toString();
    }
    public void showInfo(){
        System.out.printf("%5s %20s %20s %20s %20s  ", "ID", "NAME", "STATUS", "DATE START", "DATE END");
                System.out.println();
                System.out.printf("%5s %20s %20s %20s %20s ",this.id, this.name, this.status, showDateStart(), showDateEnd());
                System.out.println();
                System.out.printf("Description:");
                System.out.println();
                System.out.printf(getDescription());
                System.out.println();
                System.out.printf("Cordinator: " + this.coord);
                System.out.println();
                System.out.println("Team: ");
                for(User user : users){
                    System.out.println(user.getName());
                }
                System.out.println("Tasks: ");
                for(Task task : this.tasks){
                    System.out.println(task.getName());
                }
                System.out.println("Money Duration: " + getMoneyDuration());
                System.out.println("Money max: " + getMoney());
    }

    
}