package parkinglotapp;

import javafx.application.Application;
import javafx.stage.Stage;


public class ParkingLotApp extends Application {

    @Override
    public void start(Stage stage) {
        ParkingLotView parkingLotView = new ParkingLotView();
        IParkingLot iParkingLot = new ParkingLot();
        ParkingLotController parkingLotController = new ParkingLotController(iParkingLot,parkingLotView);
        parkingLotController.handleCalculateButton();
        parkingLotView.openWindow(stage);

    }
}
