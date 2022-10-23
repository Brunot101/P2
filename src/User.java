import java.util.*;

public class User {
    private int id;
    private String name;
    private String type;
    private String username;
    private String password;
    public List<Task>tasks = new ArrayList<Task>();
    public List<Project>projects = new ArrayList<Project>();
    private String question;
    private String answer;

    public User(int id, String name, String type, String username, String password, String question, String answer){
        this.id = id;
        this.name = name;
        this.type = type;
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;


    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getQuestion(){
        return this.question;
    }
    public String getAnswer(){
        return this.answer;
    }


    public void setUserName(String newName){
        this.name = newName;
    }
    public void set(String newDescription){
        this.type = newDescription;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public void setType(String newType){
        this.type = newType;
    }
    public void setUserPassword(String newPassword){
        this.password = newPassword;
    }
    public void setUserUserName(String newUserName){
        this.username = newUserName;
    }
    public void setUserQuestion(String newQuestion){
        this.question = newQuestion;
    }
    public void setUserAnswer(String newAnswer){
        this.answer = newAnswer;
    }



    
}