

import java.time.LocalDateTime;
import java.util.*;

public class Project {
    public int id;
    public String name;
    public String description;
    public String status;
    public LocalDateTime date_start;
    public LocalDateTime date_end;
    public List<User>users = new ArrayList<User>();
    public List<Task>tasks = new ArrayList<Task>();
    public String time;
    public String valor;
    
}