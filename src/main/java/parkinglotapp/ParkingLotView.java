package parkinglotapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class ParkingLotView {
    private TextField userEntryDateTextField;
    private TextField userExitDateTextField;
    private Text actionTarget;
    private Text sceneTitle;
    private Label label1;
    private Label label2;
    private ComboBox<java.io.Serializable> hourOptions1;
    private ComboBox<java.io.Serializable> minuteOptions1;
    private ComboBox<java.io.Serializable> hourOptions2;
    private ComboBox<java.io.Serializable> minuteOptions2;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private Button calculateButton;

    public ParkingLotView() {
        initialiseUIComponents();
    }

    public void initialiseUIComponents() {
        sceneTitle = new Text("Welcome");
        userEntryDateTextField = new TextField();
        userExitDateTextField = new TextField();
        label1 = new Label("Start Time: ");
        label2 = new Label("Exit Time: ");
        actionTarget = new Text();
        hourOptions1 = new ComboBox<>();
        minuteOptions1 = new ComboBox<>();
        hourOptions2 = new ComboBox<>();
        minuteOptions2 = new ComboBox<>();
        calculateButton = new Button("calculate");
        r1 = new RadioButton("General Parking");
        r2 = new RadioButton("Discounted Parking");
        r3 = new RadioButton(" Long Term Parking");
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


        hourOptions1.setValue("Hours");
        minuteOptions1.setValue("Minutes");
        hourOptions2.setValue("Hours");
        minuteOptions2.setValue("Minutes");


        userEntryDateTextField.setPromptText("DD/MM/YYYY");
        userExitDateTextField.setPromptText("DD/MM/YYYY");
        userEntryDateTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
        userExitDateTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

        sceneTitle.setFont(Font.font("Thoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 7, 1);
        grid.add(label1, 0, 2);
        grid.add(userEntryDateTextField, 1, 2);
        grid.add(hourOptions1, 2,2);
        grid.add(minuteOptions1, 3,2);

        grid.add(label2, 0, 3);
        grid.add(userExitDateTextField, 1, 3);
        grid.add(hourOptions2, 2,3);
        grid.add(minuteOptions2, 3,3);

        grid.add(calculateButton, 3, 4);
        grid.add(actionTarget,0,5);

        final ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        grid.add(r1, 1, 1);
        grid.add(r2, 2, 1);
        grid.add(r3, 3, 1);


        return grid;
    }


    public void openWindow(@NotNull Stage stage) {
        Scene scene = new Scene(initialiseLayout(), 770, 400);
        stage.setTitle("Parking Lot App");
        stage.setScene(scene);

        stage.show();
    }















    public String getUserEntryDateTextField() {
        return userEntryDateTextField.getText();
    }

    public String getUserExitDateTextField() {
        return userExitDateTextField.getText();
    }

    public Text getActionTarget() {
        return actionTarget;
    }

    public int getHourOptions1() {
        return Integer.parseInt(hourOptions1.getValue().toString());
    }

    public int getMinuteOptions1() {
        return Integer.parseInt(minuteOptions1.getValue().toString());
    }

    public int getHourOptions2() {
        return Integer.parseInt(hourOptions2.getValue().toString());
    }

    public int getMinuteOptions2() {
        return Integer.parseInt(minuteOptions2.getValue().toString());
    }

    public Button getCalculateButton() {
        return calculateButton;
    }
}
