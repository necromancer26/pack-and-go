package gui;
import javafx.scene.image.Image;
//import main.FXmain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Activite;
import models.User;
import services.ServiceActivite;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;



public class ItemController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private ImageView img;
    @FXML
    private Button modifier;

    @FXML
    private Button supprimer;

    private Activite activite;
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
    public void setData(Activite activite, MyListener myListener){
        ServiceActivite sa= new ServiceActivite();
        this.activite=activite;
        this.myListener = myListener;
        nameLabel.setText(activite.getNom_activite());
        priceLabel.setText(String.valueOf(activite.getPrix()));
        typeLabel.setText(String.valueOf(activite.getType_activite()));
        System.out.println(activite.getImgSrc());
        Image image = new Image(getClass().getResourceAsStream("../"+activite.getImgSrc()));
        img.setImage(image);

        supprimer.setOnAction(
                event -> {
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmation de suppression");
                    alert1.setHeaderText(null);
                    alert1.setContentText(" Etes-vous sure de vouloir supprimer cette activité ? ");
                    Optional<ButtonType> action = alert1.showAndWait();

                    if (action.get() == ButtonType.OK) {
                        // Crud mte3ek
                        showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                                " Succés de suppression ! ", " Suppression de l'activité est établie avec succés! ");

                            sa.supprimer(activite);


                        try {
                            root = FXMLLoader.load(getClass().getResource("./Activite.fxml"));
                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();

                        } catch (IOException ex) {

                        }

                    }
                }
        );


        modifier.setOnAction(
                event -> {
                    try {
                        switchToEditPage(event, activite);
                    } catch (IOException ex) {

                    }
                }
        );
    }
    public void switchToEditPage(ActionEvent event, Activite activite) throws IOException {
        switchPage(event, "./EditActivity.fxml", activite);

    }

    public void switchPage(ActionEvent event, String path, Activite activite) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setUserData(activite);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
