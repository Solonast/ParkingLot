module parkinglotapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens parkinglotapp to javafx.fxml;
    exports parkinglotapp;
}