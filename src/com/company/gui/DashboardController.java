package com.company.gui;

import com.company.models.Personality;
import com.company.models.UserPersonality;
import com.company.services.PersonalityController;
import com.company.services.PersonalityTest;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    PersonalityController personalityController = new PersonalityController();
    PersonalityTest personalityTest =new PersonalityTest();
    List<Personality> personalities = null;
    List<UserPersonality> userPersonalities=null;
    @FXML
    TableView<Personality> personalityTableView;

    @FXML
    TableView<UserPersonality> userPersonalityTableView;


    public void setUserPersonalities(List<UserPersonality> userPersonalities) {
        this.userPersonalities = userPersonalities;
    }

    public void initUserPersonalityTable(){
        setUserPersonalities(personalityTest.getAllPersonalityUsers());
        userPersonalityTableView.setEditable(true);
        TableColumn<UserPersonality, Integer> userPersonalityIdColumn = new TableColumn<>("User Personality ID");
        userPersonalityIdColumn.setCellValueFactory(new PropertyValueFactory<>("userPersonalityId"));
        userPersonalityIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<UserPersonality, Integer> userIdColumn = new TableColumn<>("User ID");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<UserPersonality, String > personalityColumn = new TableColumn<>("Personality ID");
        personalityColumn.setCellValueFactory(new PropertyValueFactory<>("personality"));
        personalityColumn.setCellFactory(TextFieldTableCell.forTableColumn( ));

        userPersonalityTableView.getColumns().add(0,userPersonalityIdColumn);
        userPersonalityTableView.getColumns().add(1,userIdColumn);
        userPersonalityTableView.getColumns().add(2,personalityColumn);

        userPersonalityTableView.getItems().setAll(userPersonalities);
//root.setCenter(table);
    }

    public void initPersonalityTable() {
        setPersonalities(personalityController.getAllPersonality());
        TableColumn<Personality, String> personalityIdColumn = new TableColumn<>("Personality ID");
        personalityIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalityId"));
        personalityIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> socialIdColumn = new TableColumn<>("Social ID");
        socialIdColumn.setCellValueFactory(new PropertyValueFactory<>("social"));
        socialIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> processingIdColumn = new TableColumn<>("Processing ID");
        processingIdColumn.setCellValueFactory(new PropertyValueFactory<>("processing"));
        processingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> decisionMakingIdColumn = new TableColumn<>("Decision Making ID");
        decisionMakingIdColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMaking"));
        decisionMakingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> interactionIdColumn = new TableColumn<>("Interaction ID");
        interactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("interaction"));
        interactionIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        personalityTableView.getColumns().add(0,personalityIdColumn);
        personalityTableView.getColumns().add(1,socialIdColumn);
        personalityTableView.getColumns().add(2,processingIdColumn);
        personalityTableView.getColumns().add(3,decisionMakingIdColumn);
        personalityTableView.getColumns().add(4,interactionIdColumn);

        //personalities.forEach(personality -> personalityTableView.getItems().add(personality));
        personalityTableView.getItems().setAll(personalities);

    }


    public void setPersonalities(List<Personality> personalities) {
        this.personalities = personalities;
        //personalities.forEach(s -> System.out.println(s.toString()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initPersonalityTable();
        initUserPersonalityTable();
    }
}
