import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Task {
    public int id;
    public String description;
    public LocalDateTime date_start;
    public LocalDateTime date_end;
    public User user_ass;
    public List<User>users = new ArrayList<User>();
    


}