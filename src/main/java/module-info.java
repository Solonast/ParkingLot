module parkinglotapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens parkinglotapp to javafx.fxml;
    exports parkinglotapp;
}