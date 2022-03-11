package gui;

import api.BarChart;
import api.Chart;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import models.Package;
import models.Packages;
import models.Roles;
import models.User;
import services.PackageController;
import services.PersonalityController;
import services.PersonalityTest;
import services.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import utils.UserSession;

import javax.print.attribute.HashDocAttributeSet;
import java.awt.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.List;

public class ResultController implements Initializable {

    private static String testResult = "";

    public static void setTest(String test) {
        ResultController.testResult += test;
/*        System.out.println("**********");
        System.out.println(testResult);
        System.out.println("**********");*/
    }

    public void submitReport() {
        personalityTest.ajouterUserPersonality(UserSession.getInstace().getUserId(), testResult);
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
    private WebView webView;
    @FXML
    private WebView webView2;
    @FXML
    private Label personalityResult;
    @FXML
    private VBox packagesContainer;


    private PersonalityTest personalityTest = new PersonalityTest();
    private PersonalityController personalityController = new PersonalityController();
    private HashMap<String, String> hashMap = new HashMap<>();
    //testValidationUsername
    private User user = new User("khalil", "chh", "khalil@gmail.Com", "khalilch06", "1234", 22222, LocalDateTime.of(1995, Month.JUNE, 26, 17, 45));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //URL urlPage = this.getClass().getResource("../api/index.html");
        //webView.getEngine().load(urlPage.toString());
        getReport();
        getPersonality();
        //showReportOnConsole();
        showPackages();
        //String fullName = (String) webView.getEngine().executeScript("dashboard.draw("+data+");");
        String script = "if (1===1){console.log(\" hello\")}";
        //webView.getEngine().executeScript("google.charts.setOnLoadCallback(drawDashboard);");
        webView.getEngine().loadContent(Chart.chartHTML(), "text/html");
        webView2.getEngine().loadContent(BarChart.barChartHTML(), "text/html");
        //System.out.println(transformToJavascriptArray(Question1Controller.extrovertVsIntrovertAnswersStorage));

        // System.out.println(fullName);
    }

    public void showPackages() {
        Map<String, String> packageMap = new HashMap<>();
        packageMap.put("You’re a soul-searching traveler.", "You travel not just to discover the world but to discover yourself and your place within it. Through each new experience, each new adventure, and each new fascinating personality you meet, you come to understand a little bit more about where you fit in the grand scheme of it all. What may seem like a series of disjointed adventures to others is actually a life-long journey that you’re taking inside of yourself—each new excursion teaches you a meaningful lesson and helps you construct a more holistic worldview.");
        packageMap.put("You’re an imaginative traveler.", "When you travel, you aren’t just seeing new lands or meeting new people. Rather, you’re telling yourself a story inside your mind—one that educates, inspires and revitalizes you, every step of the way. For you, travel isn’t about being in the moment; it’s about reflecting upon the moment and coming to understand what it has taught you. You enjoy dreaming up the adventures you’ll have (and reflecting upon what past adventures have taught you) even more than you enjoy actually going on them. You may internally embellish your experiences once they’re over, but why not? Some of the best moments in your life have taken place inside your mind.");
        packageMap.put("You’re a people-focused traveler.", "For you, the trip isn’t as much about the sights you see or the places you explore as it is about the people you meet (or take with you) along the way. There’s nothing you value more than forming quality memories with loved ones, and travel allots you the opportunity to do just that. You tend to look back on your trips and remember not the details of the places you visited, but the essence of the fascinating and invigorating people you met along the way, each of whom made you fall in love with your location that much more.");
        packageMap.put("You’re a slow and inquisitive traveler.", "You aren’t one for whirlwind vacations or sight-seeing trips, you want to travel slowly, meaningfully and inquisitively. You seek to learn what life is like in each new place you visit and to arrive at a profound understanding of how cultural and geographical context affects the human experience across the globe. For you, travel isn’t just a source of pleasure but a source of education. Unless you take the time to educate yourself thoroughly and meaningfully, your trip simply hasn’t served its purpose.");
        packageMap.forEach((key, value) -> {
            HBox packContainer=new HBox();
            VBox titleContainer = new VBox();
            Label title = new Label(key);
            Text text= new Text(value);
            text.setWrappingWidth(600);
            VBox textContainer = new VBox();
            textContainer.setFillWidth(true);
            textContainer.getChildren().add(text);
            textContainer.setPadding(new Insets(10));
            titleContainer.setPadding(new Insets(10));
            titleContainer.getChildren().add(title);
            packContainer.setMaxWidth(300);
            packagesContainer.setMaxWidth(300);
            packagesContainer.getChildren().add(textContainer);
            packContainer.getChildren().add(titleContainer);
            packagesContainer.getChildren().addAll(packContainer);
        });
    }

    public void setPersonalityReport(Text personalityReport) {
        this.personalityReport.setText(personalityReport.getText());
    }

    public void getPersonality() {
        personalityResult.setText(personalityController.getPersonality(testResult).getPersonalityId());
    }

    public void getReport() {

        //this.personalityReport.setText(personalityTest.getAllPersonalityUsers().toString());
        personalityTest.ajouterUserPersonality(UserSession.getInstace().getUserId(), testResult);
        hashMap = personalityTest.getPersonalityReport(UserSession.getInstace().getUserId());
        System.out.println(hashMap);
        hashMap.forEach((key, value) -> {
            if (key.equals("Extroverted") || key.equals("Introverted")) {
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


    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {

            testResult = "";
            URL fxURL = getClass().getResource("AfficherResteau.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.show();
        } catch (Exception ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    public void onButtonHotel(ActionEvent actionEvent) {
        //return to hotel
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherHotelsForm.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void onButtonResto(ActionEvent actionEvent) {
        //return to resto
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowRestauForm.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void onButtonActivity(ActionEvent actionEvent) {
        // return to activity
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Activite.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
