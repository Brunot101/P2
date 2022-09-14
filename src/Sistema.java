import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema{
    public static void main(String[] args) throws Exception {
        
        List<Project>projects = new ArrayList<Project>();
        List<User>users = new ArrayList<User>();
        
        menu();
        Scanner scn = new Scanner(System.in);
        int id = 1;
        int id_p = 1;
        int id_t = 1;

        while(true){
            System.out.printf("Escolha uma opção do menu:");
            int option = Integer.parseInt (scn.nextLine());;

            switch(option){
                case 1:
                    System.out.println("Nome do usuário:");
                    String name = scn.nextLine();
                    System.out.println("Cargo do usuário:");
                    String type = scn.nextLine();
                    System.out.println(name+" Foi adicionado com sucesso com  o cargo de "+type+", deseja fazer algo mais?");
                    User user = new User();
                    addUser(name, type, id, user );
                    
                    users.add(user);
                    
                    id++;
                    break;
                
                    case 2:
                    System.out.printf("Digite 1 para buscar e remover o funcionário pelo ID, e 2 para remover pelo nome completo");
                    int option1 = Integer.parseInt (scn.nextLine());;
                    boolean flag = false;

                    if(option1 == 1){
                        System.out.println("Digite o ID do funcionario");
                        int id_s = Integer.parseInt (scn.nextLine());
                        

                        for(int i = 0; i< users.size(); i++){
                            if(users.get(i).id == id_s){
                                users.remove(users.get(i));
                                flag = true;
                                break;
                            }
                            
                        }
                        if(!flag){
                                System.out.println("Funcionario nao encontrado");
                                
                            }
                        }
                        
                        
                    
                    else if(option1 == 2){
                        String name_s = scn.nextLine();
                        for(int i = 0; i< users.size(); i++){
                            if(users.get(i).name.equals(name_s)){
                                users.remove(users.get(i));
                                flag = true;
                                break;
                            }
                    
                            
                        }
                        if(!flag){
                            System.out.println("Funcionario nao encontrado");
                            
                        }
                        
                    }
                    else{
                        System.out.println("Opcao invalida, voltando ao menu principal...");
                    }
                    break;
                case 3:
                System.out.println("Nome do projeto");
                String namep = scn.nextLine();
                System.out.println("Descricao");
                String descr = scn.nextLine();
                System.out.println(namep+" Foi adicionado com sucesso");
                Project project = new Project();
                addProject( namep,  descr,  id_p,  project);
                project.status = "em processo de criacao";
                projects.add(project);
                
                id_p++;
                break;
                
                case 4:
                System.out.printf("Digite 1 para buscar e remover o projeto pelo ID, e 2 para remover pelo nome do projeto:");
                int option3 = Integer.parseInt (scn.nextLine());
                boolean flag2 = false;

                if(option3 == 1){
                    System.out.println("Digite o ID do projeto");
                    int id_s = Integer.parseInt (scn.nextLine());
                    

                    for(int i = 0; i< projects.size(); i++){
                        if(projects.get(i).id == id_s){
                            projects.remove(projects.get(i));
                            flag2 = true;
                            break;
                        }
                        
                    }
                    if(!flag2){
                            System.out.println("Projeto nao encontrado");
                            
                        }
                    }
                    
                    
                
                else if(option3 == 2){
                    String name_s = scn.nextLine();
                    for(int i = 0; i< projects.size(); i++){
                        if(projects.get(i).name.equals(name_s)){
                            projects.remove(projects.get(i));
                            flag2 = true;
                            break;
                        }
                
                        
                    }
                    if(!flag2){
                        System.out.println("Projeto nao encontrado");
                        
                    }
                    
                }
                else{
                    System.out.println("Opcao invalida, voltando ao menu principal...");
                }
                break;
                case 5:
                    System.out.println("Nome da tarefa");
                    String namet = scn.nextLine();
                    System.out.println("Descricao");
                    String descrt = scn.nextLine();
                    System.out.println("Digite o ID do projeto que vai receber esta tarefa");
                    int id_aux = Integer.parseInt (scn.nextLine());
                    Task task = new Task();
                    for(int i = 0; i < projects.size(); i++){
                        if(id_aux == projects.get(i).id){
                            addTask(task, namet,id_t, descrt, projects.get(i));
                            System.out.println(namet+" Foi adicionado com sucesso");
                            id_t++;
                        }
                    }
                    break;
                    
                
                case 6:
                    System.out.println("Nome do projeto");
                    String namepp = scn.nextLine();
                    queryProject(projects, namepp);
                    break;
                
                case 7:
                    System.out.println("Nome do usuario");
                    String nameu = scn.nextLine();
                    queryUser(users, nameu);
                    break;
                
                case 8:
                    System.out.println("Nome da atividade");
                    String nametask = scn.nextLine();
                    queryTask(projects, nametask);
                    break;
                
                case 9:
                    report(projects);
                    break;

                case 0:
                    
                    // projects.get(0).coord = users.get(0);
                    // projects.get(0).changeDateStart("2022-09-11T22:00");
                    // projects.get(0).changeDateEnd("2023-09-11T21:00");
                    // projects.get(0).money = "400";
                    // projects.get(0).money_time = "1 ano";
                    // projects.get(0).duration = "1 ano";
                    

                    
                    System.out.println("Encerrando o sistema...");break;
                    
                    
                default: break;
                
             
            
            }
            if(option == 0) break;
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
    }

    public static void addProject(String namep, String descr, int id, Project project){
        project.name = namep;
        project.description = descr;
        project.status = "Em processo de criacao";
        project.id = id;
        project.date_start = LocalDateTime.now();
    }
    public static void addUser(String name, String type, int id, User user){
        user.name = name;
        user.type = type;
        user.id = id;
    }
    public static void addTask(Task task, String namet,int id, String descrt, Project project){
        task.name = namet;
        task.id = id;
        task.description = descrt;
        task.date_start = LocalDateTime.now();
        project.tasks.add(task);
        
    }
    public static void removeTask(int id_t, int id_p, List <Project> projects){
        for(int i = 0; i < projects.size(); i++){
            if(id_p == projects.get(i).id){
                for(int j = 0; j< projects.get(i).tasks.size(); j++){
                    if(id_t == projects.get(i).tasks.get(j).id){
                        projects.get(i).tasks.remove(projects.get(i).tasks.get(j));
                    }
                }
            }
        }
        
    }
    public static void queryUser(List <User> users, String name){
        
        for(User user: users){
            if( user.name.equalsIgnoreCase(name)){
                System.out.printf("%5s %40s %30s ", "ID", "NAME", "TYPE");
                System.out.println();
                System.out.printf("%5s %40s %30s ", user.id, user.name, user.type);
                System.out.println();
                break;
            }

        
        }
    
    }

    public static void queryProject(List <Project> projects, String name){
        
        for(Project project: projects){
            if( project.name.equalsIgnoreCase(name)){
                System.out.printf("%5s %20s %20s %20s %20s  ", "ID", "NAME", "STATUS", "DATE START", "DATE END");
                System.out.println();
                System.out.printf("%5s %20s %20s %20s %20s ", project.id, project.name, project.status, project.date_start, project.date_end);
                System.out.println();
                System.out.printf("Description:");
                System.out.println();
                System.out.printf(project.description);
                System.out.println();
                System.out.printf("Cordinator: " + project.coord);
                System.out.println();
                System.out.println("Team: ");
                for(User user : project.users){
                    System.out.println(user.name);
                }
                System.out.println("Tasks: ");
                for(Task task : project.tasks){
                    System.out.println(task.name);
                }
                System.out.println("Duration: " + project.duration);
                System.out.println("Money: " + project.money);
                System.out.println("Money time: " + project.money_time);

                break;
            }

        
        }
    
    }


    public static void queryTask(List <Project> projects, String name){
        
        for(Project project: projects){
            for(Task task : project.tasks){

                if( task.name.equalsIgnoreCase(name)){
                    System.out.printf("%5s %20s %20s %20s %20s  ", "ID", "NAME",  "DATE START", "DATE END", "PROJECT");
                    System.out.println();
                    System.out.printf("%5s %20s %20s  %20s %20s ", task.id, task.name,  task.date_start, task.date_end, project.name);
                    System.out.println();
                    System.out.printf("Description:");
                    System.out.println();
                    System.out.printf(task.description);
                    System.out.println();
                    System.out.printf("Cordinator: " + task.user_ass);
                    System.out.println();
                    System.out.println("Team: ");
                    for(User user : task.users){
                        System.out.println(user.name);
                    }
                    
            }

                break;
            }

        
        }
    
    }
    public static void report(List <Project> projects){
        int count = 0;

        for(Project project: projects){

            count += project.tasks.size();
        }

        System.out.println("Projects: " + projects.size());
        System.out.println("Tasks: " + count);

    }

    public static void addUserProject(List<Project> projects, List<User> users, String name_u, String name_p){
        int  projectaux = -1;
        int useraux = -1;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).name.equalsIgnoreCase(name_u)){
                useraux = i;
                break;
            }
            
        }
        for(int i = 0; i < projects.size(); i++){
            if(projects.get(i).name.equalsIgnoreCase(name_p)){
                projectaux = i;
                break;
            }
            
        }
        if(projectaux == -1 || useraux == -1) return;
        projects.get(projectaux).users.add(users.get(useraux));
        users.get(useraux).projects.add(projects.get(projectaux));


    }


    public static void addUserTask(List<Project> projects, List<User> users, String name_u, String name_t){
        int  taskauxi = -1;
        int  taskauxj = -1;
        int useraux = -1;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).name.equalsIgnoreCase(name_u)){
                useraux = i;
                break;
            }
            
        }
        for(int i = 0; i < projects.size(); i++){
            for(int j = 0; j < projects.get(i).tasks.size(); j++){

                if(projects.get(i).tasks.get(j).name.equalsIgnoreCase(name_t)){
                    taskauxi = i;
                    taskauxj = j;
                }
            }
        }
        if(taskauxi == -1 || useraux == -1  || taskauxj == -1) return;
        projects.get(taskauxi).tasks.get(taskauxj).users.add(users.get(useraux));
        users.get(useraux).tasks.add(projects.get(taskauxi).tasks.get(taskauxj));
        


    }


}


