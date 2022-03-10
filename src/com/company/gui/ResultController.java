package com.company.gui;

import com.company.api.BarChart;
import com.company.api.Chart;
import com.company.models.Package;
import com.company.models.Roles;
import com.company.models.User;
import com.company.services.PackageController;
import com.company.services.PersonalityController;
import com.company.services.PersonalityTest;
import com.company.services.Test;
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
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class ResultController implements Initializable {

    private static String testResult = "";

    public static void setTest(String test) {
        ResultController.testResult += test;
/*        System.out.println("**********");
        System.out.println(testResult);
        System.out.println("**********");*/
    }

    public void submitReport() {
        personalityTest.ajouterUserPersonality(user, testResult);
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
    private User user = new User("khalil", "ch", "kh@gmail.com", "khalilch06", "1234", 55111222, Roles.CLIENT, LocalDateTime.of(1995, Month.JUNE, 26, 17, 45), LocalDateTime.now(), LocalDateTime.now());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        URL urlPage = this.getClass().getResource("../api/index.html");
        webView.getEngine().load(urlPage.toString());
        getReport();
        getPersonality();
        showReportOnConsole();
        showPackages();
        //String fullName = (String) webView.getEngine().executeScript("dashboard.draw("+data+");");
        String script="if (1===1){console.log(\" hello\")}";
        //webView.getEngine().executeScript("google.charts.setOnLoadCallback(drawDashboard);");
        webView.getEngine().loadContent(Chart.chartHTML(),"text/html");
        webView2.getEngine().loadContent(BarChart.barChartHTML(),"text/html");
        //System.out.println(transformToJavascriptArray(Question1Controller.extrovertVsIntrovertAnswersStorage));

       // System.out.println(fullName);
    }

    public void showPackages(){
        List<Package> packageList= PackageController.getAllPackages();
        packageList.forEach(aPackage -> {
            HBox packageContainer=new HBox();
            packageContainer.setPadding(new Insets(30));
            packageContainer.setAlignment(Pos.CENTER);
            Label packageName=new Label(aPackage.getPackageName());
            packageContainer.getChildren().add(packageName);
            packagesContainer.getChildren().add(packageContainer);
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
        personalityTest.ajouterUserPersonality(user, testResult);
        hashMap = personalityTest.getPersonalityReport(user);
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
    private String transformToJavascriptArray(int[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (int str : arr)
            sb.append(str).append(", ");

        if (sb.length() > 1)
            sb.replace(sb.length() - 2, sb.length(), "");

        sb.append("]");

        return sb.toString();
    }
    public void showReportOnConsole() {

        // print personality results in a table.
        System.out.println("\nYour choice at a glance\n");
        System.out.printf("|%5s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", " ", "A", "B",
                " ", "A", "B", " ", "A", "B", " ", "A", "B");
        int numbering = 1;
        System.out.printf("%s%n", "-".repeat(74));
        for (int i = 0; i < Question1Controller.extrovertVsIntrovertAnswersStorage.length; i++) {
            System.out.printf("|%5d | %3s | %3s | %3d | %3s | %3s | %3d | %3s | %3s | %3d | %3s | %3s |%n", numbering++,
                    Test.placeCheckmark(Question1Controller.extrovertVsIntrovertAnswersStorage[i], 1),
                    Test.placeCheckmark(Question1Controller.extrovertVsIntrovertAnswersStorage[i], 2),
                    numbering++,Test.placeCheckmark(Question2Controller.sensingVsIntuitionsAnswersStorage[i], 1),
                    Test.placeCheckmark(Question2Controller.sensingVsIntuitionsAnswersStorage[i], 2),
                    numbering++,
                    Test.placeCheckmark(Question3Controller.thinkingVsFeelingAnswersStorage[i], 1),
                    Test.placeCheckmark(Question3Controller.thinkingVsFeelingAnswersStorage[i], 2), numbering++,
                    Test.placeCheckmark(Question4Controller.judgingVsPerceivingAnswersStorage[i], 1),
                    Test.placeCheckmark(Question4Controller.judgingVsPerceivingAnswersStorage[i], 2));
        }

        System.out.printf("%s%n", "-".repeat(74));
        System.out.printf("|%5s | %3d | %3d | %3s | %3d | %3d | %3s | %3d | %3d | %3s | %3d | %3d |%n", "TOTAL",
                Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 1),
                Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 0)," ",
                Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 1),
                Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 0), " ",
                Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 1),
                Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 0), " ",
                Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 1),
                Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 0));
        System.out.printf("%s%n", "-".repeat(74));
        System.out.printf("|%5s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", " ", "E", "I",
                " ", "S", "N", " ", "T", "F", " ", "J", "P");

        System.out.println("Your personality type is " + testResult);
        System.out.print("For your personality interpretation, visit : ");
        System.out.println("https://www.truity.com/page/16-personality-types-myers-briggs");

        System.out.println("*******************************");
        System.out.printf("%s%n", "-".repeat(74));
        System.out.printf("|%5s | %3d | %3d | %3s | %3d | %3d | %3s | %3d | %3d | %3s | %3d | %3d |%n", "TOTAL",
                Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 1),
                Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 0)," ",
                Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 1),
                Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 0), " ",
                Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 1),
                Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 0), " ",
                Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 1),
                Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 0));
        System.out.printf("%s%n", "-".repeat(74));
        System.out.printf("|%5s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", " ", "E", "I",
                " ", "S", "N", " ", "T", "F", " ", "J", "P");
        System.out.println("*******************************");

    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Menu.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            MenuController menuController = fxmlLoader.getController();
            testResult = "";
        } catch (Exception ioException) {
            System.err.println(ioException.getMessage());
        }
    }
}
