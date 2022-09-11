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
                    
                case 0:
                    projects.get(0).changeProjectName("Agora eh kappa fi");;
                    System.out.printf(projects.get(0).status);
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
    
}




