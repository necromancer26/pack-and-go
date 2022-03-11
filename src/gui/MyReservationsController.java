
package gui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.modelVol;

import java.net.URL;
import java.util.ResourceBundle;

public class MyReservationsController implements Initializable {

    @FXML
    private TableView<?> tableview;



    @FXML
    private TableColumn<?, ?> col_depart;

    @FXML
    private TableColumn<?, ?> col_destination;

    @FXML
    private TableColumn<?, ?> col_classe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //col_depart.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
               // cellData.getValue().compagnie_aerienProperty());

    }
}
