package com.company.gui;

import com.company.models.*;
import com.company.services.PersonalityComponentsController;
import com.company.services.PersonalityController;
import com.company.services.PersonalityTest;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    //list1= list2.stream().filter(c ->c.getNomhotel().startsWith(val)).collect(Collectors.toList());
    //list1= list2.stream().sorted((o1,o2)->o1.getNomhotel().compareTo(o2.getNomhotel())).collect(Collectors.toList());
    //list1= list2.stream().sorted((o1,o2)->o1.getNbrChambre()-o2.getNbrChambre()).collect(Collectors.toList());
    PersonalityController personalityController = new PersonalityController();
    PersonalityTest personalityTest = new PersonalityTest();
    List<Personality> personalities = null;
    List<UserPersonality> userPersonalities = null;
    List<SocialStyle> socialStyles = null;
    List<ProcessingStyle> processingStyles = null;
    List<DecisionMakingStyle> decisionMakingStyles = null;
    List<InteractionStyle> interactionStyles = null;


    @FXML
    TableView<Personality> personalityTableView;
    @FXML
    TableView<UserPersonality> userPersonalityTableView;
    @FXML
    TableView<SocialStyle> socialStyleTableView;
    @FXML
    TableView<ProcessingStyle> processingStyleTableView;
    @FXML
    TableView<DecisionMakingStyle> decisionMakingStyleTableView;
    @FXML
    TableView<InteractionStyle> interactionStyleTableView;


    public void setUserPersonalities(List<UserPersonality> userPersonalities) {
        this.userPersonalities = userPersonalities;
    }

    public void initSocialStyles() {
        socialStyleTableView.setEditable(true);
        TableColumn<SocialStyle, String> socialIdIdColumn = new TableColumn<>("Social ID");
        socialIdIdColumn.setCellValueFactory(new PropertyValueFactory<>("socialId"));
        socialIdIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<SocialStyle, String> socialNameColumn = new TableColumn<>("Social Name");
        socialNameColumn.setCellValueFactory(new PropertyValueFactory<>("socialName"));
        socialNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<SocialStyle, String> socialDetailsColumn = new TableColumn<>("Social Details");
        socialDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("socialDetails"));
        socialDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        socialStyleTableView.getColumns().add(0, socialIdIdColumn);
        socialStyleTableView.getColumns().add(1, socialNameColumn);
        socialStyleTableView.getColumns().add(2, socialDetailsColumn);

        socialStyleTableView.getItems().setAll(socialStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initInteractionStyles() {
        interactionStyleTableView.setEditable(true);
        TableColumn<InteractionStyle, String> interactionIdColumn = new TableColumn<>("Interaction ID");
        interactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("interactionId"));
        interactionIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<InteractionStyle, String> interactionNameColumn = new TableColumn<>("Interaction Name");
        interactionNameColumn.setCellValueFactory(new PropertyValueFactory<>("interactionName"));
        interactionNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<InteractionStyle, String> interactionDetailsColumn = new TableColumn<>("Interaction Details");
        interactionDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("interactionDetails"));
        interactionDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        interactionStyleTableView.getColumns().add(0, interactionIdColumn);
        interactionStyleTableView.getColumns().add(1, interactionNameColumn);
        interactionStyleTableView.getColumns().add(2, interactionDetailsColumn);

        interactionStyleTableView.getItems().setAll(interactionStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initProcessingStyles() {
        processingStyleTableView.setEditable(true);
        TableColumn<ProcessingStyle, String> processingIdColumn = new TableColumn<>("Processing ID");
        processingIdColumn.setCellValueFactory(new PropertyValueFactory<>("processingId"));
        processingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<ProcessingStyle, String> processingNameColumn = new TableColumn<>("Processing Name");
        processingNameColumn.setCellValueFactory(new PropertyValueFactory<>("processingName"));
        processingNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<ProcessingStyle, String> processingDetailsColumn = new TableColumn<>("Processing Details");
        processingDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("processingDetails"));
        processingDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        processingStyleTableView.getColumns().add(0, processingIdColumn);
        processingStyleTableView.getColumns().add(1, processingNameColumn);
        processingStyleTableView.getColumns().add(2, processingDetailsColumn);

        processingStyleTableView.getItems().setAll(processingStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initDecisionMakingStyles() {
        decisionMakingStyleTableView.setEditable(true);
        TableColumn<DecisionMakingStyle, String> decisionMakingIdColumn = new TableColumn<>("Decision MakingID");
        decisionMakingIdColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMakingId"));
        decisionMakingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<DecisionMakingStyle, String> decisionMakingNameColumn = new TableColumn<>("Decision Making Name");
        decisionMakingNameColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMakingName"));
        decisionMakingNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<DecisionMakingStyle, String> decisionMakingDetailsColumn = new TableColumn<>("Decision Making Details");
        decisionMakingDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMakingDetails"));
        decisionMakingDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        decisionMakingStyleTableView.getColumns().add(0, decisionMakingIdColumn);
        decisionMakingStyleTableView.getColumns().add(1, decisionMakingNameColumn);
        decisionMakingStyleTableView.getColumns().add(2, decisionMakingDetailsColumn);

        decisionMakingStyleTableView.getItems().setAll(decisionMakingStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initUserPersonalityTable() {
        setUserPersonalities(personalityTest.getAllPersonalityUsers());
        userPersonalityTableView.setEditable(true);
        TableColumn<UserPersonality, Integer> userPersonalityIdColumn = new TableColumn<>("User Personality ID");
        userPersonalityIdColumn.setCellValueFactory(new PropertyValueFactory<>("userPersonalityId"));
        userPersonalityIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<UserPersonality, Integer> userIdColumn = new TableColumn<>("User ID");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<UserPersonality, String> personalityColumn = new TableColumn<>("Personality ID");
        personalityColumn.setCellValueFactory(new PropertyValueFactory<>("personality"));
        personalityColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        userPersonalityTableView.getColumns().add(0, userPersonalityIdColumn);
        userPersonalityTableView.getColumns().add(1, userIdColumn);
        userPersonalityTableView.getColumns().add(2, personalityColumn);

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

        personalityTableView.getColumns().add(0, personalityIdColumn);
        personalityTableView.getColumns().add(1, socialIdColumn);
        personalityTableView.getColumns().add(2, processingIdColumn);
        personalityTableView.getColumns().add(3, decisionMakingIdColumn);
        personalityTableView.getColumns().add(4, interactionIdColumn);

        //personalities.forEach(personality -> personalityTableView.getItems().add(personality));
        personalityTableView.getItems().setAll(personalities);

    }


    public void setPersonalities(List<Personality> personalities) {
        this.personalities = personalities;
        //personalities.forEach(s -> System.out.println(s.toString()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PersonalityComponentsController personalityComponentsController = new PersonalityComponentsController();
        socialStyles = personalityComponentsController.getSocialStyles();
        decisionMakingStyles = personalityComponentsController.getDecisionMakingStyles();
        interactionStyles = personalityComponentsController.getInteractionStyles();
        processingStyles = personalityComponentsController.getProcessingStyles();
        initPersonalityTable();
        initUserPersonalityTable();
        initSocialStyles();
        initProcessingStyles();
        initDecisionMakingStyles();
        initInteractionStyles();
    }
}
