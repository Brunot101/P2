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
                    user.name = name;
                    user.type = type;
                    user.id = id;
                    
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
                project.name = namep;
                project.description = descr;
                project.status = "Em processo de criacao";
                project.id = id;
                
                project.date_start = LocalDateTime.now();
                projects.add(project);
                
                id++;
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
                    
                case 0: System.out.println("Encerrando o sistema...");break;
                    
                default: break;
                
             
            
            }
            if(option == 0) break;
        }
    }



    static void menu(){

        System.out.println("------------------------------------------");
        System.out.println("(1)Adicionar funcionário");
        System.out.println("(2)Remover funcionário");
        System.out.println("(3)Adicionar projeto");
        System.out.println("(4)Remover projeto");
    }
    
}




