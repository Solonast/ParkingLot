package parkinglotapp;

import java.time.LocalDateTime;

public interface IParkingLot {

    public double calculatePrice(ITicket ticket);
}
