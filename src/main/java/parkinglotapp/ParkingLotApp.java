package parkinglotapp;

import javafx.application.Application;
import javafx.stage.Stage;


public class ParkingLotApp extends Application {

    @Override
    public void start(Stage stage) {
        ParkingLotView parkingLotView = new ParkingLotView();

        ParkingLotController parkingLotController = new ParkingLotController(parkingLotView);
        parkingLotController.handleRadioButtons();
        parkingLotController.handleCalculateButton();
        parkingLotView.openWindow(stage);

    }
}
