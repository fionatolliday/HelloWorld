package model;
import interfaces.DateTimeInterface;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTime implements DateTimeInterface {

    public String getDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mma");
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        String time = myDateObj.format(formattedTime);
        String date = myDateObj.format(formattedDate);

        return " - the time on the server is " + time + " on " + date;
    }
}
