module com.example.parkinglotapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parkinglotapp to javafx.fxml;
    exports com.example.parkinglotapp;
}