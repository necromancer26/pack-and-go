package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
//import main.FXmain;

import models.Activite;
import services.ServiceActivite;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddActivityController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Activite activite;
    private int countEvents = 0;


    @FXML
    private VBox ChosenActivityCard1;
    @FXML
    private VBox ChosenActivityCard2;

    @FXML
    private Label nomActiviteLabel;

    @FXML
    private Label prixActiviteLabel;

    @FXML
    private Label typeActiviteLabel;

    @FXML
    private ImageView activityImg;

    @FXML
    private TextField nomActivite;

    @FXML
    private TextField typeActivite;

    @FXML
    private TextField prixActivite;

    @FXML
    private TextField adresseActivite;

    @FXML
    private TextField paysActivite;

    @FXML
    private Button ajouterPhoto;
    @FXML
    private Button previewActivite;


    public String pathfile = new String();
    private Image image;
    private MyListener myListener;
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(activite);
    }


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }


   /* private void setPreviewActivite(Activite activite) {
        nomActiviteLabel.setText(activite.getNom_activite());
        typeActiviteLabel.setText(String.valueOf(activite.getType_activite()));
        // ChosenActivityCard.setStyle("-fx-background-color: #888888" +
        //  "    -fx-background-radius: 30;");
        image = new Image(getClass().getResourceAsStream("../"+activite.getImgSrc()));
        activityImg.setImage(image);

    }

    */

    @FXML
    private void add(ActionEvent event) {
        ServiceActivite us = new ServiceActivite();
        System.out.println(pathfile +"HERE" );
        activite = new Activite(nomActivite.getText(),typeActivite.getText(),Float.parseFloat(prixActivite.getText()),adresseActivite.getText(),paysActivite.getText(),pathfile);

        // activite.setType_activite(Integer.parseInt(txtLastName.getText()));

        System.out.println (activite);
        us.ajouterActivite(activite);

        showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                "succès !", "Ajout d'activité effectuée avec succès");


    }
    @FXML
    private void switchToList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("./Activite.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ChosenActivityCard2.setVisible(false);
        ChosenActivityCard2.managedProperty().bind(ChosenActivityCard2.visibleProperty());

        ajouterPhoto.setOnAction(e ->{
            FileChooser fc= new FileChooser();
            File file =fc.showOpenDialog(stage);
            String path = "img\\";
            String imagecomp = file.getAbsolutePath();
            System.out.println("1 "+imagecomp);
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                pathfile = path +imagecomp.substring(index + 1);

            }


        });
        previewActivite.setOnAction(e ->{


            nomActiviteLabel.setText(nomActivite.getText());
            typeActiviteLabel.setText(typeActivite.getText());
            prixActiviteLabel.setText(prixActivite.getText());
            // ChosenActivityCard.setStyle("-fx-background-color: #888888" +
            //  "    -fx-background-radius: 30;");
            image = new Image(getClass().getResourceAsStream("../"+pathfile));
            activityImg.setImage(image);
            ChosenActivityCard2.setVisible(true);
            ChosenActivityCard2.managedProperty().bind(ChosenActivityCard2.visibleProperty());

        });


    }
}
