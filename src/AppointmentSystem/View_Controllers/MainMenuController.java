package AppointmentSystem.View_Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for the MainMenuView.fxml, used to implement action methods and initialize values for the stage. Uses javafx library.
 * @author josealvarezpulido
 */
public class MainMenuController implements Initializable {
    /**
     * a resource bundle that gets the default Locale and the location of the resource bundle used for translation purposes.
     */
    ResourceBundle bundle = ResourceBundle.getBundle("AppointmentSystem/ResourceBundle/Nat", Locale.getDefault());

    @FXML
    private Button customerButton;

    @FXML
    private Button scheduleButton;

    @FXML
    private Button reports;

    @FXML
    private Button exitButton;

    @FXML
    private Label titleLabel;

    /**
     *
     * @param url
     * @param resourceBundle
     * initialize the buttons and labels in this method to use the resource bundle to change language.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        titleLabel.setText(bundle.getString("MainMenu"));
        customerButton.setText(bundle.getString("Customer"));
        scheduleButton.setText(bundle.getString("Schedule"));
        reports.setText(bundle.getString("Reports"));
        exitButton.setText(bundle.getString("Exit"));

    }

    @FXML
    void customerMenuButton(ActionEvent event) throws IOException
    {
        Parent customerMenuParent = FXMLLoader.load(getClass().getResource("/AppointmentSystem/View_Controllers/CustomerMenuView.fxml"));
        Scene customerMenuScene = new Scene(customerMenuParent);
        Stage customerMenuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        customerMenuStage.setScene(customerMenuScene);
        customerMenuStage.show();
    }
    @FXML
    void scheduleMenuButton(ActionEvent event)  throws IOException
    {
        Parent scheduleMenuParent = FXMLLoader.load(getClass().getResource("/AppointmentSystem/View_Controllers/ScheduleMenuView.fxml"));
        Scene scheduleMenuScene = new Scene(scheduleMenuParent);
        Stage scheduleMenuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scheduleMenuStage.setScene(scheduleMenuScene);
        scheduleMenuStage.show();
    }
    @FXML
    void reportsViewButton(ActionEvent event)  throws IOException
    {
        Parent reportsParent = FXMLLoader.load(getClass().getResource("/AppointmentSystem/View_Controllers/ReportsView.fxml"));
        Scene reportsScene = new Scene(reportsParent);
        Stage reportsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        reportsStage.setScene(reportsScene);
        reportsStage.show();
    }
    @FXML
    void exitButton(ActionEvent event) throws IOException
    {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION, bundle.getString("ExitApplication"));
        Optional<ButtonType> result = exit.showAndWait();
        if(result.get() == ButtonType.OK){
            Parent exitParent = FXMLLoader.load(getClass().getResource("/AppointmentSystem/View_Controllers/LogInView.fxml"));
            Scene exitScene = new Scene(exitParent);
            Stage exitStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            exitStage.setScene(exitScene);
            exitStage.show();
        }
    }
}
