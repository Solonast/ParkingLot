package parkinglotapp;

import java.time.LocalDateTime;

public class ParkingLotController {
    IParkingLot iParkingLot;
    ITicket iTicket;
    ParkingLotView parkingLotView;

    public ParkingLotController(IParkingLot iParkingLot, ParkingLotView parkingLotView){
        this.iParkingLot=iParkingLot;
        this.parkingLotView=parkingLotView;
    }

    public void handleCalculateButton(){
        parkingLotView.getCalculateButton().setOnAction(e -> {
            String entryDay = parkingLotView.getUserEntryDateTextField();
            String exitDay = parkingLotView.getUserExitDateTextField();
            int entryHour = parkingLotView.getHourOptions1();
            int exitHour = parkingLotView.getHourOptions2();
            int entryMinute = parkingLotView.getMinuteOptions1();
            int exitMinute = parkingLotView.getMinuteOptions2();
            String[] entryDayArray = entryDay.split("/");
            String[] exitDayArray = exitDay.split("/");
            LocalDateTime entryTime = LocalDateTime.of(Integer.parseInt(entryDayArray[2]),
                    Integer.parseInt(entryDayArray[1]), Integer.parseInt(entryDayArray[0]),
                    entryHour,entryMinute);
            LocalDateTime exitTime = LocalDateTime.of(Integer.parseInt(exitDayArray[2]),
                    Integer.parseInt(exitDayArray[1]), Integer.parseInt(exitDayArray[0]),
                    exitHour,exitMinute);
            iTicket = new Ticket(entryTime,exitTime);
            double price = iParkingLot.calculatePrice(iTicket);
            parkingLotView.getActionTarget().setText(String.valueOf(price));
        });
    }
}
