

import java.time.LocalDateTime;
import java.util.*;

public class Project {
    private int id;
    private String name;
    private String description;
    private String status;
    public DateRange date;
    public User coord;
    public List<User>users = new ArrayList<User>();
    public List<Task>tasks = new ArrayList<Task>();
    public String money_duration;
    public String money_max = "0";
    // public String money_time;



    public Project(int id, String name, String description,  DateRange date, String money_duration){
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = "em processo de criacao";
        this.date = date;
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
    



    public void setName(String newName){
        this.name = newName;
    }
    public void setMoneyDuration(String newMoneyDuration){
        this.money_duration = newMoneyDuration;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    // public void setProjectMoney(String newMoney){
    //     this.money = newMoney;
    // }
    
    
    
    public void changeStatus(){
        if(this.date.getDateStart() != null && this.date.getDateStart() != null
        && !this.tasks.isEmpty() && !this.users.isEmpty() && !this.money_duration.isEmpty()
        && !this.money_max.isEmpty() ){

            try{
                if(!this.coord.getType().equalsIgnoreCase("pesquisador")|| !!this.coord.getType().equalsIgnoreCase("professor"))
                throw new Exception("Coordenador nao possui o cargo para alterar o status do projeto");
                if( this.status.equalsIgnoreCase( "em processo de criacao") ){
                    this.status = "inciado";
                }
    
                else if(this.status.equalsIgnoreCase("inciado") && this.date.getDateStart().isAfter(LocalDateTime.now()) ){
                    this.status = "em andamento";
    
                }
                else if(this.status.equalsIgnoreCase("em andamento") ){
                    this.status = "concluido";
    
                }
            }
            catch(Exception e){

            }
            
                

        }
    }

    
    public void showInfo(){
        System.out.printf("%5s %20s %20s %20s %20s  ", "ID", "NAME", "STATUS", "DATE START", "DATE END");
                System.out.println();
                System.out.printf("%5s %20s %20s %20s %20s ",this.id, this.name, this.status, date.showDateStart(), date.showDateEnd());
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