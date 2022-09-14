public class User {
    public int id;
    public String name;
    public String type;
    public String username;
    public String password;

    public void changeUserName(String newName){
        this.name = newName;
    }
    public void changeTypeUser(String newDescription){
        this.type = newDescription;
    }
    
}