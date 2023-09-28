package parkinglotapp;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ParkingLotView {
    private TextField userEntryDateTextField;
    private TextField userExitDateTextField;
    private Text actionTarget;
    private Text sceneTitle;
    private Label label1;
    private Label label2;
    private ComboBox hourOptions1;
    private ComboBox minuteOptions1;
    private ComboBox hourOptions2;
    private ComboBox minuteOptions2;
    private Button calculateButton;

    public ParkingLotView() {
        initialiseUIComponents();
        //initialiseLayout();
    }

    public void initialiseUIComponents() {
        sceneTitle = new Text("Welcome");
        userEntryDateTextField = new TextField();
        userExitDateTextField = new TextField();
        label1 = new Label("Start Time: ");
        label2 = new Label("Exit Time: ");
        actionTarget = new Text();
        hourOptions1 = new ComboBox();
        minuteOptions1 = new ComboBox();
        hourOptions2 = new ComboBox();
        minuteOptions2 = new ComboBox();
        calculateButton = new Button("calculate");
    }

    public GridPane initialiseLayout() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        for (int i = 0; i <= 23; i++) {
            hourOptions1.getItems().add(i);
            hourOptions2.getItems().add(i);
        }
        for (int i = 0; i <= 59; i++) {
            minuteOptions1.getItems().add(i);
            minuteOptions2.getItems().add(i);
        }


        hourOptions1.setValue("Hours:");
        minuteOptions1.setValue("Minutes");
        hourOptions2.setValue("Hours:");
        minuteOptions2.setValue("Minutes");


        userEntryDateTextField.setPromptText("DD/MM/YYYY");
        userExitDateTextField.setPromptText("DD/MM/YYYY");
        userEntryDateTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
        userExitDateTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

//        userEntryDateTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//            validateInput();
//        });

        sceneTitle.setFont(Font.font("Thoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 7, 1);
        grid.add(label1, 0, 1);
        grid.add(userEntryDateTextField, 1, 1);
        grid.add(hourOptions1, 2,1);
        grid.add(minuteOptions1, 3,1);

        grid.add(label2, 0, 2);
        grid.add(userExitDateTextField, 1, 2);
        grid.add(hourOptions2, 2,2);
        grid.add(minuteOptions2, 3,2);

        grid.add(calculateButton, 3, 3);

        return grid;
    }

//    public void validateInput() {
//        LocalDate entryDate;
//        try {
//            entryDate = setDate(userEntryDateTextField.toString(), "d/M/uuuu");
//        } catch (DateTimeParseException e) {
//            System.out.println("Invalid date!");
//            e.printStackTrace();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private static LocalDate setDate(String strDate, String dateFormat) throws ParseException {
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
//
//        //sdf.setLenient(false);
//
//        LocalDate date = LocalDate.parse(strDate, dtf);
//
//        return date;
//    }

    public void openWindow(@NotNull Stage stage) {


        Scene scene = new Scene(initialiseLayout(), 770, 400);
        stage.setTitle("Parking Lot App");
        stage.setScene(scene);

        stage.show();


    }















    public TextField getUserEntryDateTextField() {
        return userEntryDateTextField;
    }

    public TextField getUserExitDateTextField() {
        return userExitDateTextField;
    }

    public Text getActionTarget() {
        return actionTarget;
    }

    public Text getSceneTitle() {
        return sceneTitle;
    }

    public ComboBox getHourOptions1() {
        return hourOptions1;
    }

    public ComboBox getMinuteOptions1() {
        return minuteOptions1;
    }

    public ComboBox getHourOptions2() {
        return hourOptions2;
    }

    public ComboBox getMinuteOptions2() {
        return minuteOptions2;
    }

    public Button getCalculateButton() {
        return calculateButton;
    }
}
