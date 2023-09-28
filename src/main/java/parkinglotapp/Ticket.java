package parkinglotapp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket implements ITicket {
    LocalDateTime entryTime;
   LocalDateTime exitTime;

    public Ticket(LocalDateTime entryTime, LocalDateTime exitTime) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    @Override
    public int[] calculateDuration() {
        int[] duration = new int[3];
        duration[0] = (int) ChronoUnit.DAYS.between(entryTime, exitTime);
        duration[1] = (int) ChronoUnit.HOURS.between(entryTime, exitTime) -
                (int) ChronoUnit.DAYS.between(entryTime, exitTime) * 24;
        duration[2] = (int) ChronoUnit.MINUTES.between(entryTime, exitTime) -
               (int) ChronoUnit.HOURS.between(entryTime, exitTime) * 60;
        return duration;
    }
}
