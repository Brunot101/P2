

import java.time.LocalDateTime;
import java.util.*;

public class Project {
    public int id;
    public String name;
    public String description;
    public String status;
    public LocalDateTime date_start;
    public LocalDateTime date_end;
    public User coord;
    public List<User>users = new ArrayList<User>();
    public List<Task>tasks = new ArrayList<Task>();
    public String duration;
    public String money;
    public String money_time;

    public void changeProjectName(String newName){
        this.name = newName;
    }
    public void changeProjectDescription(String newDescription){
        this.description = newDescription;
    }
    public void changeProjectMoney(String newMoney){
        this.money = newMoney;
    }
    public void changeDateStart(String dateTimeStart){
        LocalDateTime ex = LocalDateTime.parse(dateTimeStart);
        this.date_start = ex;
    }

    public void changeDateEnd(String dateTimeEnd){
        LocalDateTime ex = LocalDateTime.parse(dateTimeEnd);
        this.date_end = ex;
    }
    
    public void changeStatus(){
        if(this.date_start != null && this.date_end != null && 
        (this.coord.type.equalsIgnoreCase("professor")  || this.coord.type.equalsIgnoreCase("pesquisador") )
        && !this.tasks.isEmpty() && !this.users.isEmpty() && !this.duration.isEmpty()
        && !this.money.isEmpty() && !this.money_time.isEmpty()){
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
    
}