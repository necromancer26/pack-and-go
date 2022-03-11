package gui;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.PersonalityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuTestController implements Initializable {
    @FXML
    private Button menuButton;
    @FXML
    private Button toBackOffice;
    @FXML
    private VBox pane = new VBox();

    PersonalityController personalityController = new PersonalityController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    public void init() {
        ScrollPane scrollPane = new ScrollPane();
        toBackOffice.setVisible(false);
        scrollPane.setContent(pane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        PersonalityController personalityController = new PersonalityController();
        //System.out.println(personalityController.getAllPersonality().toString());
    }

    public void onButtonClicked(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/Question1.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            ScrollPane scrollPane = new ScrollPane();
            //scrollPane.setStyle("-fx-border-color:red;-fx-border-width:5;-fx-background-color:blue;");
            scrollPane.setContent(root);
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            Scene scene = new Scene(scrollPane);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void onAdminClicked(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Dashboard.fxml"));
            ScrollPane scrollPane = new ScrollPane();
            VBox yourNewView = fxmlLoader.load();
            //scrollPane.setStyle("-fx-border-color:red;-fx-border-width:5;-fx-background-color:blue;");
            scrollPane.setContent(yourNewView);
            scrollPane.setMinHeight(900);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            pane.getChildren().setAll(scrollPane);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
