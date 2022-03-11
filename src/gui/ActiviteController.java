package gui;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
//import main.FXmain;
import models.Activite;
import models.Roles;
import models.User;
import services.ServiceActivite;
import services.ServiceTicket;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import utils.UserSession;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import static models.Roles.ADMIN;
import static models.Roles.CLIENT;

public class ActiviteController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Activite activite;
    private int countEvents = 0;

    @FXML
    private VBox ChosenActivityCard;

    @FXML
    private Label activityNameLabel;

    @FXML
    private Label activityPriceLabel;
    @FXML
    private Label activityAdresseLabel;

    @FXML
    private Label activityTypeLabel;

    @FXML
    private ImageView activityImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ComboBox<Integer> nbTicket=new ComboBox<>();

    @FXML
    private Button boutonReserver;
    @FXML
    private Button menu;
    @FXML
    private Button menu1;
    @FXML
    private Button Ajouter;
    @FXML
    private Button vol;
    @FXML
    private Button resto;
    @FXML
    private Button test;



    @FXML
    private GridPane grid;
    @FXML
    private TextField tfRech;

    private MyListener myListener;

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

@FXML
    private void switchToList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddActivity.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    private void setChosenActivite(Activite activite) {
       activityNameLabel.setText(activite.getNom_activite());
       activityPriceLabel.setText(String.valueOf(activite.getPrix()));
       activityTypeLabel.setText(activite.getType_activite());
       activityAdresseLabel.setText(activite.getAdresse());
        boutonReserver.setOnAction(e ->{
            ServiceTicket ticket = new ServiceTicket();

            User u = new User(1,"Salah", "kakou", "s@g.com","sasa","azerty",28383838, CLIENT, LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000),LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000),LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000));

            ticket.ajouterTicket(activite,u);

            showAlert(Alert.AlertType.INFORMATION, ((Node) e.getSource()).getScene().getWindow(),
                    "succès !", "Ajout d'activité effectuée avec succès");
            Document document = new Document();
            try
            {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Ticket"+activite.getNom_activite()+".pdf"));
                document.open();
                document.add(new Paragraph("Nom : "+activite.getNom_activite()+"\nPrix : "+activite.getPrix()*nbTicket.getValue()+"DT\nAdresse : "+activite.getAdresse()+"\n Nom participant : "+u.getFirst_name()+"\nNumero : "+u.getNumber()));
                document.close();
                writer.close();
            } catch (DocumentException ev)
            {
                ev.printStackTrace();
            } catch (FileNotFoundException ev)
            {
                ev.printStackTrace();
            }


        });
       // ChosenActivityCard.setStyle("-fx-background-color: #888888" +
              //  "    -fx-background-radius: 30;");
      Image image = new Image(getClass().getResourceAsStream("../"+activite.getImgSrc()));

      activityImg.setImage(image);


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Roles userRole = null;
        if (UserSession.getInstace() != null) {
            userRole = UserSession.getInstace().getRole();
        }
        if (userRole == CLIENT) {
            menu1.setVisible(false);
            menu1.managedProperty().bind(menu1.visibleProperty());
            Ajouter.setVisible(false);
            Ajouter.managedProperty().bind(Ajouter.visibleProperty());
        }
        if (userRole == ADMIN) {

            ChosenActivityCard.setVisible(false);
            ChosenActivityCard.managedProperty().bind(ChosenActivityCard.visibleProperty());
            vol.setVisible(false);
            vol.managedProperty().bind(vol.visibleProperty());
            test.setVisible(false);
            test.managedProperty().bind(test.visibleProperty());
            resto.setVisible(false);
            resto.managedProperty().bind(resto.visibleProperty());
        }
        ServiceActivite serviceActivite = new ServiceActivite();
        List<Activite> listeActivite=serviceActivite.getAll();
        nbTicket.getItems().addAll(1,2,3,4,5,6,7,8,9,10);

        if (listeActivite.size() > 0) {
            setChosenActivite(listeActivite.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Activite activite)
                {
                    setChosenActivite(activite);
                }
            };
        }
        int column=0;
        int row=1;
        try {
            for(int i=0;i<listeActivite.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));

                    AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(listeActivite.get(i), myListener);
                if(column==3){
                    column=0;
                    row++;
                }
                grid.add(anchorPane, column++, row); //(child,column,row)

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
            } catch (IOException e) {
                e.printStackTrace();
            }





    }

    @FXML
    private void menuprincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLGSTuser.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void vol(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLGSTuser.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void resto(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FrontRestau.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void test(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuTest.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void hotel(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AfficherHotelFront.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
