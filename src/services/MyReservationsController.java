
package services;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyReservationsController {

    @FXML
    private TableView<?> tableview;

    @FXML
    private TableColumn<?, ?> col_id_res;

    @FXML
    private TableColumn<?, ?> col_id_vol;

    @FXML
    private TableColumn<?, ?> col_dep;

    @FXML
    private TableColumn<?, ?> col_arr;

    @FXML
    private TableColumn<?, ?> col_date;

}
