import java.time.LocalDateTime;
import java.util.*;

public class DateRange {
    private LocalDateTime date_start;
    private LocalDateTime date_end;

    public DateRange(LocalDateTime date_start, LocalDateTime date_end){
        this.date_start = date_start;
        this.date_end = date_end;

    }

    public void setDateStart(String dateTimeStart){
        LocalDateTime ex = LocalDateTime.parse(dateTimeStart);
        this.date_start = ex;
    }

    public void setDateEnd(String dateTimeEnd){
        LocalDateTime ex = LocalDateTime.parse(dateTimeEnd);
        this.date_end = ex;
    }
    public LocalDateTime getDateStart(){
        return this.date_start;
    }

    public LocalDateTime getDateEnd(){
        return this.date_end;
    }


    public String showDateStart(){
        
        return this.date_start.toString();
    }

    public String showDateEnd(){
        
        return this.date_end.toString();
    }
}
