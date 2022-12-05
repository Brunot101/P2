import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;


public class Sistema implements Login{
    public static void main(String[] args) throws Exception {
        
        List<Project>projects = new ArrayList<Project>();
        List<User>users = new ArrayList<User>();
        User admin = new User(0, "admin", "professor", "admin", "admin", "null", "null");
        users.add(admin);
        int option = 0;
        
        
        
        Scanner scn = new Scanner(System.in);
        Indices indices = new Indices();
        
        String[] list1 = {"graduando", "mestrando", "doutorando", "professor", "pesquisador", "profissional", "tecnico"};
        List<String> list2 = Arrays.asList(list1);
        List<String> types = new ArrayList<String>();
        types.addAll(list2);
        
        while(true){

            System.out.println("(1)Login");
            System.out.println("(2)Recuperar a senha");
            try {
                option = Integer.parseInt (scn.nextLine());
            } catch (Exception e) {
                e.getMessage();
            }
            switch(option){

                case 1:
                    System.out.println("Username:");
                    String username1 = scn.nextLine();
                    System.out.println("Password:");
                    String password1 = scn.nextLine();
                    login(users, projects, indices, username1, password1);
                    break;

                case 2:
                    System.out.println("Username:");
                    username1 = scn.nextLine();
                    changePassword(users, username1);
                    break;
                default:break;
            }
            
        }
    }


    public static void menu(){

        System.out.println("------------------------------------------");
        System.out.println("(1)Adicionar funcionário");
        System.out.println("(2)Remover funcionário");
        System.out.println("(3)Adicionar projeto");
        System.out.println("(4)Remover projeto");
        System.out.println("(5)Adicionar atividade");
        System.out.println("(6)Consultar projeto");
        System.out.println("(7)Consultar usuario");
        System.out.println("(8)Consultar atividade");
        System.out.println("(9)Imprimir relatorio");
        System.out.println("(10)Login");
        System.out.println("(11)Recuperar senha");
        System.out.println("(12)Editar usuario");
        System.out.println("(13)Editar atividade");
        System.out.println("(14)Editar projeto");
        System.out.println("(15)Associar usuario a um projeto");
        System.out.println("(16)Associar usuario a uma atividade");
        System.out.println("(0)Logout");
    }

    // public static void addProject(String namep, String descr, int id, Project project){
    //     project.name = namep;
    //     project.description = descr;
    //     project.status = "Em processo de criacao";
    //     project.id = id;
    //     project.date_start = LocalDateTime.now();
    // }
    // public static void addUser(String name, String type, int id, User user, String username, String password, String question, String answer){
    //     user.name = name;
    //     user.type = type;
    //     user.id = id;
    //     user.username = username;
    //     user.password = password;
    //     user.question = question;
    //     user.answer = answer;
    // }
    // public static void addTask(Task task, String namet,int id, String descrt, Project project){
    //     task.name = namet;
    //     task.id = id;
    //     task.description = descrt;
    //     task.date_start = LocalDateTime.now();
    //     project.tasks.add(task);
        
    // }
    public static void removeTask(int id_t, int id_p, List <Project> projects){
        for(int i = 0; i < projects.size(); i++){
            if(id_p == projects.get(i).getId()){
                for(int j = 0; j< projects.get(i).tasks.size(); j++){
                    if(id_t == projects.get(i).tasks.get(j).getId()){
                        projects.get(i).tasks.remove(projects.get(i).tasks.get(j));
                    }
                }
            }
        }
        
    }
    public static void queryUser(List <User> users, String name){
        
        boolean flag = false;

        
            for(User user: users){
                if( user.getName().equalsIgnoreCase(name)){
                    System.out.printf("%5s %40s %30s ", "ID", "NAME", "TYPE");
                    System.out.println();
                    System.out.printf("%5s %40s %30s ", user.getId() ,user.getName(), user.getType());
                    System.out.println();
                    
                    flag = true;
                    break;
                }
    
            
            }
        if(!flag){
            System.out.println("Usuario nao cadastrado");
        }
        
    
    }

    public static void queryProject(List <Project> projects, String name){
        
        boolean flag = false;
        for(Project project: projects){
            if( project.getName().equalsIgnoreCase(name)){
                project.showInfo();
                flag = true;
                

                break;
            }

        
        
        }
        if(!flag){
            System.out.println("Projeto nao existente");
        }
    
    }


    public static void queryTask(List <Project> projects, String name){
        
        boolean flag = false;
        for(Project project: projects){
            for(Task task : project.tasks){

                if( task.getName().equalsIgnoreCase(name)){
                   task.showInfo();
                   flag = true;
                    
            }

                break;
            }
        
            

        
        }
        if(!flag){
            System.out.println("Tarefa nao existente");
        }
    
    }
    public static void report(List <Project> projects){
        int count = 0;

        try{
            for(Project project: projects){

                count += project.tasks.size();
            }
    
            System.out.println("Projects: " + projects.size());
            System.out.println("Tasks: " + count);
        }
        catch(Exception e){
            System.out.println("Erro!");
        }
        

    }

    public static void addUserProject(List<Project> projects, List<User> users, String name_u, String name_p){
        int  projectaux = -1;
        int useraux = -1;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equalsIgnoreCase(name_u)){
                useraux = i;
                break;
            }
            
        }
        for(int i = 0; i < projects.size(); i++){
            if(projects.get(i).getName().equalsIgnoreCase(name_p)){
                projectaux = i;
                break;
            }
            
        }
        if(projectaux == -1 || useraux == -1){
            System.out.println("Algo deu errado!");
            return;
        } 
        projects.get(projectaux).users.add(users.get(useraux));
        users.get(useraux).projects.add(projects.get(projectaux));


    }


    public static void addUserTask(List<Project> projects, List<User> users, String name_u, String name_t){
        int  taskauxi = -1;
        int  taskauxj = -1;
        int useraux = -1;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equalsIgnoreCase(name_u)){
                useraux = i;
                break;
            }
            
        }
        for(int i = 0; i < projects.size(); i++){
            for(int j = 0; j < projects.get(i).tasks.size(); j++){

                if(projects.get(i).tasks.get(j).getName().equalsIgnoreCase(name_t)){
                    taskauxi = i;
                    taskauxj = j;
                }
            }
        }
        if(taskauxi == -1 || useraux == -1  || taskauxj == -1) return;
        projects.get(taskauxi).tasks.get(taskauxj).users.add(users.get(useraux));
        users.get(useraux).tasks.add(projects.get(taskauxi).tasks.get(taskauxj));
        


    }

    public static void login(List<User> users, List<Project> projects, Indices indices, String username, String password) {

        boolean flag = false;

        try{
            for(User user : users){

                if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                        System.out.println("Login efetuado com sucesso! Bem vindo " + user.getName());
                        LoginUser newuser = new LoginUser(user);
                        if(user.getType().equalsIgnoreCase("professor") || user.getType().equalsIgnoreCase("pesquisador")){
                            newuser.login(projects, users, indices);
                        }
                        else{

                            newuser.login();
                        }

                        flag = true;
                        
                    }
                }
                if(flag == false){
                    throw new Exception("Login invalido");
                    
                }
        }
        catch(Exception e){
           
        }
        
            
        

        
        
    }

    public static void changePassword(List<User> users, String username ){

        boolean flag = false;
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                flag = true;
                Scanner scn = new Scanner(System.in);
                System.out.printf(user.getQuestion()+"?");
                String answer = scn.nextLine();
                if(answer.equalsIgnoreCase(user.getAnswer())){
                    System.out.printf("Digite a nova senha:");
                    String password = scn.nextLine();
                    user.setPassword(password);
                    
                    break;
                }
                else{
                    System.out.println("Resposta errada");
                    break;
                }
            }
            if(flag == false){
                System.out.println("Usuario nao encontrado!");
                break;
            }
        }
    }
    public static DateRange StringToDateRange(String date1, String date2){

        LocalDateTime a;
        LocalDateTime b;

        a =  LocalDateTime.parse(date1);
        b =  LocalDateTime.parse(date2);
        DateRange date_range = new DateRange(a,b);
        return date_range;
    }
    

        
        
        
    
}

