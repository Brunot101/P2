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
        
        String namet;       
        String descrt;         
        int id_aux;
        String namep;
        String descr;
        String date_start;
        String date_end;
        LocalDateTime a;
        LocalDateTime b;
        
        
        menu();
        Scanner scn = new Scanner(System.in);
        int id = 1;
        int id_p = 1;
        int id_t = 1;
        String[] list1 = {"graduando", "mestrando", "doutorando", "professor", "pesquisador", "profissional", "tecnico"};
        List<String> list2 = Arrays.asList(list1);
        List<String> types = new ArrayList<String>();
        types.addAll(list2);
        
        while(true){
            System.out.printf("Escolha uma opção do menu:");
            int option = Integer.parseInt (scn.nextLine());
            

            
            switch(option){
                case 1:
                    try{
                        
                        System.out.println("Nome do usuário:");
                        String name = scn.nextLine();
                        System.out.println("Cargo do usuário {graduando, mestrando, doutorando, professor, pesquisador, profissional ou tecnico}:");
                        String type = scn.nextLine();
                        if(!types.contains(type)){
                            throw new Exception("Cargo inválido");
                        }
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
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
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
                    namep = scn.nextLine();
                    System.out.println("Descricao");
                    descr = scn.nextLine();
                    System.out.println("Digite a data e hora do inicio do projeto no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                    try{
                        date_start = scn.nextLine();
                        System.out.println("Digite a data e hora do termino do projeto no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                        date_end = scn.nextLine();
                        
                        System.out.println("Digite a vigencia da bolsa projeto");
                        String money_duration = scn.nextLine();
                        System.out.println(namep+" Foi adicionado com sucesso");
                        
                        Project project = new Project(id_p, namep, descr, StringToDateRange(date_start, date_end), money_duration);
                        projects.add(project);
                        
                        
                        id_p++;

                    }
                    catch(DateTimeParseException e){
                        System.out.println("Formato de data e hora incorreto");

                    }
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
                    namet = scn.nextLine();
                    System.out.println("Descricao:");
                    descrt = scn.nextLine();
                    System.out.println("Digite o ID do projeto que vai receber esta tarefa:");
                    
                    try{

                        id_aux = Integer.parseInt (scn.nextLine());
                        System.out.println("Digite a data e hora do inicio da tarefa no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                        String date_start1 = scn.nextLine();
                        System.out.println("Digite a data e hora do termino da tarefa no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                        String date_end1 = scn.nextLine();
                        
                        
                        for(int i = 0; i < projects.size(); i++){
                            if(id_aux == projects.get(i).getId()){
                                Task task = new Task(id_t, namet, descrt,StringToDateRange(date_start1, date_end1), projects.get(i).getName());
                                projects.get(i).tasks.add(task);
                                
                                System.out.println(namet+" Foi adicionado com sucesso");
                                id_t++;
                            }
                        }

                    }
                    catch(NumberFormatException e){
                        System.out.println("Entrada incorreta");
                    }
                    catch(DateTimeParseException e){

                        System.out.println("Formato de data e hora incorreto");
                    }
                    catch(NullPointerException e ){
                        System.out.println("Projeto nao encontrado");
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
                case 12:
                    System.out.println("Digite o nome do usuário que deseja editar:");
                    String username3 = scn.nextLine();
                    boolean flagu = false;

        
                    for(User user: users){
                        if( user.getName().equalsIgnoreCase(username3)){
                            
                            flagu = true;
                            
                            try{
                                System.out.println("Digite as informacoes que deseja alterar. Caso nao queira alterar basta teclar Enter");
                                System.out.println("Nome do usuário:");
                                String newname = scn.nextLine();
                                System.out.println("Cargo do usuário {graduando, mestrando, doutorando, professor, pesquisador, profissional ou tecnico}:");
                                String newtype = scn.nextLine();
                                if(!types.contains(newtype) && newtype.length()!=0){
                                    throw new Exception("Cargo inválido");
                                }
                                System.out.println("Username:");
                                String newusername = scn.nextLine();
                                System.out.println("Password:");
                                String newpassword = scn.nextLine();
                                System.out.println("Digite uma pergunta para recuperação de senha:");
                                String newquestion = scn.nextLine();
                                System.out.println("Digite a resposta para a pergunta:");
                                String newanswer = scn.nextLine();
                                if(newname.length() != 0){
                                    user.setUserName(newname);
                                }
                                if(newtype.length() != 0){
                                    user.setType(newtype);
                                }
                                if(newusername.length() != 0){
                                    user.setUserUserName(newusername);
                                }
                                if(newpassword.length() != 0){
                                    user.setUserPassword(newpassword);
                                }
                                if(newquestion.length() != 0){
                                    user.setUserQuestion(newquestion);
                                }
                                if(newanswer.length() != 0){
                                    user.setUserAnswer(newanswer);
                                }
                                
                            }
                            catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    if(!flagu){
                        System.out.println("Usuario nao cadastrado");
                    }
                
                    
                    break;
                case 13:
                    System.out.println("Nome da tarefa que deseja alterar os dados:");
                    namet = scn.nextLine();
                    boolean flagt = false;
                    try{
                        for(Project project: projects){
                            for(Task task : project.tasks){
                                if( task.getName().equalsIgnoreCase(namet)){
                                    System.out.println("Digite as informacoes que deseja alterar. Caso nao queira alterar basta teclar Enter");
                                    System.out.println("Nome da tarefa:");
                                    namet = scn.nextLine();
                                    System.out.println("Descricao:");
                                    descrt = scn.nextLine();
                                    System.out.println("Digite a data e hora do inicio da tarefa no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                                    String date_start1 = scn.nextLine();
                                    System.out.println("Digite a data e hora do termino da tarefa no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                                    String date_end1 = scn.nextLine();
                                    
                                    
                                    if(namet.length() != 0){
                                        task.setName(namet);
                                    }
                                    if(descrt.length() != 0){
                                        task.setDescription(descrt);
                                    }
                                    if(date_start1.length() != 0){
                                        LocalDateTime ex1 = LocalDateTime.parse(date_start1);
                                        task.date.setDateStart(date_start1);
                                    }
                                    
                                    if(date_end1.length() != 0){
                                        LocalDateTime ex2 = LocalDateTime.parse(date_end1);
                                        task.date.setDateEnd(date_end1);
                                    }
                                flagt = true;
                                    
                            }

                                break;
                            }
                        
                            

                        
                        }
                        if(!flagt){
                            System.out.println("Tarefa nao existente");
                        }

                        
                        
                        
                        

                    }
                    catch(NumberFormatException e){
                        System.out.println("Entrada incorreta");
                    }
                    catch(DateTimeParseException e){

                        System.out.println("Formato de data e hora incorreto");
                    }
                    break;
                case 14:
                    System.out.println("Nome do projeto que deseja editar");
                    namep = scn.nextLine();
                    boolean flagh = false;
                    for(Project project: projects){
                        if( project.getName().equalsIgnoreCase(namep)){
                            try{
                                System.out.println("Digite as informacoes que deseja alterar. Caso nao queira alterar basta teclar Enter");

                                System.out.println("Nome do projeto");
                                namep = scn.nextLine();
                                System.out.println("Descricao");
                                descr = scn.nextLine();
                                System.out.println("Digite a data e hora do inicio do projeto no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                                date_start = scn.nextLine();
                                System.out.println("Digite a data e hora do termino do projeto no formato AAAA-MM-DDTHH:MM:SS. Os segundos  podem ser omitidos");
                                date_end = scn.nextLine();
                                
                                System.out.println("Digite a vigencia da bolsa projeto");
                                String money_duration = scn.nextLine();
                                
                                if(namep.length()!= 0){
                                    project.setName(namep);
                                }
                                if(descr.length()!= 0){
                                    project.setDescription(descr);
                                }
                                if(date_start.length()!= 0){
                                    a =  LocalDateTime.parse(date_start);
                                    project.date.setDateStart(date_start);
                                }
                                if(date_end.length()!= 0){
                                    b =  LocalDateTime.parse(date_end);
                                    project.date.setDateEnd(date_end);
                                }
                                if(money_duration.length()!= 0){
                                    project.setMoneyDuration(money_duration);
                                }
                                

                            
        
                            }
                            catch(DateTimeParseException e){
                                System.out.println("Formato de data e hora incorreto");
        
                            }
                            flagh = true;
                            

                            break;
                        }

                    }
                    if(!flagh){
                        System.out.println("Projeto nao existente");
                    }
                    
                    
                    
                    break;
                case 15:
                    System.out.println("Qual o nome do usuario voce deseja associar ao projeto?");
                    username3 = scn.nextLine();
                    System.out.println("Qual o nome do projeto que ele sera associado?");
                    namep = scn.nextLine();
                    addUserProject(projects, users, username3, namep);
                    break;
                case 16:
                    System.out.println("Qual o nome do usuario voce deseja associar ao projeto?");
                    username3 = scn.nextLine();
                    System.out.println("Qual o nome da atividade que ele sera associado?");
                    namet = scn.nextLine();
                    addUserTask(projects, users, username3, namet);
                    
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
        System.out.println("(12)Editar usuario");
        System.out.println("(13)Editar atividade");
        System.out.println("(14)Editar projeto");
        System.out.println("(15)Associar usuario a um projeto");
        System.out.println("(16)Associar usuario a uma atividade");
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

    public static void login(List<User> users, String username, String password) {

        boolean flag = false;

        try{
            for(User user : users){

                if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                        System.out.println("Login efetuado com sucesso! Bem vindo " + user.getName());
                        LoginUser newuser = new LoginUser(user);
                        newuser.login();

                        flag = true;
                        
                    }
                }
                if(flag == false){
                    throw new Exception("Login invalido");
                    
                }
        }
        catch(Exception e){
           System.out.println(e.getMessage());
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


