package gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
//import main.FXmain;
import models.Activite;
import models.User;
import services.ServiceActivite;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditActivityController  {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Activite activite;
    private int countEvents = 0;
    public String pathfile = new String();

    @FXML
    private Button modifierPhoto;


    @FXML
    private TextField activityNameLabel;

    @FXML
    private TextField activityTypeLabel;

    @FXML
    private TextField activityPriceLabel;

    @FXML
    private TextField activityAdresseLabel;

    @FXML
    private TextField activityPaysLabel;

    @FXML
    private AnchorPane ap;


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    @FXML
    private void receiveData(MouseEvent event) {
        if (countEvents == 0) {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            // Step 2
            Activite a = (Activite) stage.getUserData();
            activite = a;
            System.out.print(activite);
            // Step 3
            activityNameLabel.setText(a.getNom_activite());
           activityTypeLabel.setText(a.getType_activite());
            activityAdresseLabel.setText(a.getAdresse());
            activityPriceLabel.setText(String.valueOf(a.getPrix()));
            activityPaysLabel.setText(a.getPays());
            pathfile=a.getImgSrc();

            countEvents++;
        }
    }

    @FXML
    private void update(ActionEvent event) {
        ServiceActivite us = new ServiceActivite();
        activite.setNom_activite(activityNameLabel.getText());

        activite.setAdresse(activityAdresseLabel.getText());
        activite.setPrix(Float.parseFloat(activityPriceLabel.getText()));
        activite.setPays(activityPaysLabel.getText());
        activite.setImgSrc(pathfile);
        activite.setType_activite(activityTypeLabel.getText());
        System.out.println (activite);
        us.modifier(activite);
        showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                "succès!", "Modification d'activité effectuée avec succès");

    }
    @FXML
    private void switchToList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("./Activite.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
   private void mod(ActionEvent event) {

        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(stage);
        String path = "img/";
        String imagecomp = file.getAbsolutePath();
        System.out.println("1 " + imagecomp);
        int index = imagecomp.lastIndexOf('/');
        if (index > 0) {
            pathfile = path + imagecomp.substring(index + 1);
        }
    }





}
