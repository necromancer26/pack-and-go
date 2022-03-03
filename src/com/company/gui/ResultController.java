package com.company.gui;

import com.company.models.Roles;
import com.company.models.User;
import com.company.services.PersonalityController;
import com.company.services.PersonalityTest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.management.relation.Role;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class ResultController implements Initializable {

    private static String testResult="";

    public static void setTest(String test) {
        ResultController.testResult += test;
    }
    public void submitReport(){
        personalityTest.ajouterUserPersonality(user,testResult);
    }

    public static String getTestResult() {
        return testResult;
    }

    @FXML
    private Button returnToMenu;
    @FXML
    private VBox pane = new VBox();
    @FXML
    private Text personalityReport;
    @FXML
    private Label socialStyle;
    @FXML
    private Text socialStyleDescription;

    @FXML
    private Label processingStyle;
    @FXML
    private Text processingStyleDescription;

    @FXML
    private Label decisionMakingStyle;
    @FXML
    private Text decisionMakingStyleDescription;

    @FXML
    private Label interactionStyle;
    @FXML
    private Text interactionStyleDescription;

    @FXML
    private Label personalityResult;

    private PersonalityTest personalityTest = new PersonalityTest();
    private PersonalityController personalityController = new PersonalityController();
    private HashMap<String, String> hashMap = new HashMap<>();
    private User user = new User("khalil", "ch", "kh@gmail.com", "khalilch06", "1234", 55111222, Roles.CLIENT, LocalDateTime.of(1995, Month.JUNE, 26, 17, 45), LocalDateTime.now(), LocalDateTime.now());

    public void setPersonalityReport(Text personalityReport) {
        this.personalityReport.setText(personalityReport.getText());
    }
    public void getPersonality(){
        personalityResult.setText(personalityController.getPersonality(testResult).getPersonalityId());
    }

    public void getReport() {

        //this.personalityReport.setText(personalityTest.getAllPersonalityUsers().toString());
        personalityTest.ajouterUserPersonality(user,testResult);
        hashMap = personalityTest.getPersonalityReport(user);
        hashMap.forEach((key, value) -> {
            if (key.equals("Extroverted")  || key.equals("Introverted")) {
                socialStyle.setText(key);
                socialStyleDescription.setText(value);
            }
            if (key.equals("Sensing") || key.equals("Intuition")) {
                processingStyle.setText(key);
                processingStyleDescription.setText(value);
            }
            if (key.equals("Feeling") || key.equals("Thinking")) {
                decisionMakingStyle.setText(key);
                decisionMakingStyleDescription.setText(value);

            }
            if (key.equals("Judging") || key.equals("Perceiving")) {
                interactionStyle.setText(key);
                interactionStyleDescription.setText(value);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getReport();
        getPersonality();
    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Menu.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            MenuController menuController = fxmlLoader.getController();
           testResult="";
        } catch (Exception ioException) {
            System.err.println(ioException.getMessage());
        }
    }
}
