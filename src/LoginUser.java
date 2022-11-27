import java.util.*;

public class LoginUser  {
    
    User user;

    public LoginUser(User user){
        this.user = user;

    }

    public  void login(){
        Scanner scn = new Scanner(System.in);
        int option=-1;
        System.out.println("(1) Mostrar dados");
        System.out.println("(2) Mostrar projetos");
        System.out.println("(3) Mostrar atividades");
        System.out.println("(4) Sair");
        
        while(option != 4){
            option = Integer.parseInt (scn.nextLine());
            switch(option){
    
                case 1:
                    System.out.printf("%5s %40s %30s ", "ID", "NAME", "TYPE");
                    System.out.println();
                    System.out.printf("%5s %40s %30s ", user.getId() ,user.getName(), user.getType());
                    System.out.println();
                    break;

                case 2:
                    for(Project project : user.projects){
                        project.showInfo();
                    }
                    break;
                case 3:
                    for(Task task : user.tasks){
                        task.showInfo();

                    }
                    break;

                case 4:
                    break;
            }
        }

    }

}
