/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FrontRestauController implements Initializable {

    @FXML
    private TableView<?> tableview1FrontR;
    @FXML
    private TableColumn<?, ?> coltypeR;
    @FXML
    private TableColumn<?, ?> colnomR;
    @FXML
    private TableColumn<?, ?> coladresseR;
    @FXML
    private TableColumn<?, ?> colPaysR;
    @FXML
    private TableColumn<?, ?> col_image1;
    @FXML
    private TableColumn<?, ?> coltelR;
    @FXML
    private TableColumn<?, ?> colIdR;
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lblStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
