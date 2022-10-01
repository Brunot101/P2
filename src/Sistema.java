import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema implements Login{
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
            int option = Integer.parseInt (scn.nextLine());

            switch(option){
                case 1:
                    System.out.println("Nome do usuário:");
                    String name = scn.nextLine();
                    System.out.println("Cargo do usuário:");
                    String type = scn.nextLine();
                    System.out.println("Username:");
                    String username = scn.nextLine();
                    System.out.println("Password:");
                    String password = scn.nextLine();
                    System.out.println("Digite uma pergunta para recuperação de senha:");
                    String question = scn.nextLine();
                    System.out.println("Digite a resposta para a pergunta:");
                    String answer = scn.nextLine();
                    System.out.println(name+" Foi adicionado com sucesso com  o cargo de "+type+", deseja fazer algo mais?");
                    User user = new User(id, name, type, username, password, question, answer);
                    
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
                            if(users.get(i).getId() == id_s){
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
                            if(users.get(i).getName().equals(name_s)){
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
                System.out.println("Digite a data e hora do inicio do projeto no formato AAAA-MM-DDTHH:MM:SS. Os segundos e minutos podem ser omitidos");
                String date_start = scn.nextLine();
                System.out.println("Digite a data e hora do termino do projeto no formato AAAA-MM-DDTHH:MM:SS. Os segundos e minutos podem ser omitidos");
                String date_end = scn.nextLine();
                System.out.println("Digite a vigencia da bolsa projeto");
                String money_duration = scn.nextLine();
                System.out.println(namep+" Foi adicionado com sucesso");
                
                Project project = new Project(id_p, namep, descr, date_start, date_end, money_duration);
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
                        if(projects.get(i).getId() == id_s){
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
                        if(projects.get(i).getName().equals(name_s)){
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
                    System.out.println("Nome da tarefa:");
                    String namet = scn.nextLine();
                    System.out.println("Descricao:");
                    String descrt = scn.nextLine();
                    System.out.println("Digite o ID do projeto que vai receber esta tarefa:");
                    int id_aux = Integer.parseInt (scn.nextLine());
                    System.out.println("Digite a data e hora do inicio da tarefa no formato AAAA-MM-DDTHH:MM:SS. Os segundos e minutos podem ser omitidos");
                    String date_start1 = scn.nextLine();
                    System.out.println("Digite a data e hora do termino da tarefa no formato AAAA-MM-DDTHH:MM:SS. Os segundos e minutos podem ser omitidos");
                    String date_end1 = scn.nextLine();
                    Task task = new Task(id_t, namet, descrt, date_start1, date_end1);
                    for(int i = 0; i < projects.size(); i++){
                        if(id_aux == projects.get(i).getId()){
                            projects.get(i).tasks.add(task);
                            
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
                
                case 10:
                    
                    System.out.println("Username:");
                    String username1 = scn.nextLine();
                    System.out.println("Password:");
                    String password1 = scn.nextLine();
                    
                    
                    login(users, username1, password1);
                    
                    break;
                
                case 11:
                    System.out.println("Digite o username:");
                    String username2 = scn.nextLine();
                    changePassword(users, username2);
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
        System.out.println("(10)Login");
        System.out.println("(11)Recuperar senha");
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
        
        for(User user: users){
            if( user.getName().equalsIgnoreCase(name)){
                System.out.printf("%5s %40s %30s ", "ID", "NAME", "TYPE");
                System.out.println();
                System.out.printf("%5s %40s %30s ", user.getId() ,user.getName(), user.getType());
                System.out.println();
                break;
            }

        
        }
    
    }

    public static void queryProject(List <Project> projects, String name){
        
        for(Project project: projects){
            if( project.getName().equalsIgnoreCase(name)){
                project.showInfo();
                

                break;
            }

        
        }
    
    }


    public static void queryTask(List <Project> projects, String name){
        
        for(Project project: projects){
            for(Task task : project.tasks){

                if( task.getName().equalsIgnoreCase(name)){
                   task.showInfo();
                    
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
        if(projectaux == -1 || useraux == -1) return;
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

    public static void login(List<User> users, String username, String password){

        boolean flag = false;

        for(User user : users){

            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                System.out.println("Login efetuado com sucesso! Bem vindo " + user.getName());
                flag = true;
                
            }
        }
        if(flag == false){
            System.out.println("Login inválido!");
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
}


