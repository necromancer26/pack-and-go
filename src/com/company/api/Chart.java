package com.company.api;

import com.company.gui.Question1Controller;
import com.company.gui.Question2Controller;
import com.company.gui.Question3Controller;
import com.company.gui.Question4Controller;
import com.company.services.Test;

import java.util.StringJoiner;

public class Chart {
    public static String chartHTML() {
        String text = "<html>\n" +
                "\n" +
                "<head>\n" +
                "  <!--Load the AJAX API-->\n" +
                "  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "  <script type=\"text/javascript\">\n" +
                "    // Load the Visualization API and the controls package.\n" +
                "    google.charts.load('current', { 'packages': ['corechart', 'controls'] });\n" +
                "\n" +
                "    // Set a callback to run when the Google Visualization API is loaded.\n" +
                "    google.charts.setOnLoadCallback(drawDashboard);\n" +
                "\n" +
                "    // Callback that creates and populates a data table,\n" +
                "    // instantiates a dashboard, a range slider and a pie chart,\n" +
                "    // passes in the data and draws it.\n" +
                "\n" +
                "    function drawDashboard() {\n" +
                "\n" +
                "      // Create our data table.\n" +
                "      var data = google.visualization.arrayToDataTable([\n" +
                "        ['Name', 'Donuts eaten'],\n" +
                "        ['Extroversion', " + Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 1) + "],\n" +
                "        ['Introversion', " + Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 0) + "],\n" +
                "        ['Sensing', " + Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 1) + "],\n" +
                "        ['Intuition', " + Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 0) + "],\n" +
                "        ['Thinking', " + Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 1) + "],\n" +
                "        ['Feeling'," + Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 0) + "],\n" +
                "        ['Judging', " + Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 1) + "],\n" +
                "        ['Perceiving', " + Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 0) + "]\n" +
                "      ]);\n" +
                "\n" +
                "      // Create a dashboard.\n" +
                "      var dashboard = new google.visualization.Dashboard(\n" +
                "        document.getElementById('dashboard_div'));\n" +
                "\n" +
                "      // Create a range slider, passing some options\n" +
                "      var donutRangeSlider = new google.visualization.ControlWrapper({\n" +
                "        'controlType': 'NumberRangeFilter',\n" +
                "        'containerId': 'filter_div',\n" +
                "        'options': {\n" +
                "          'filterColumnLabel': 'Donuts eaten'\n" +
                "        }\n" +
                "      });\n" +
                "\n" +
                "      // Create a pie chart, passing some options\n" +
                "      var pieChart = new google.visualization.ChartWrapper({\n" +
                "        'chartType': 'PieChart',\n" +
                "        'containerId': 'chart_div',\n" +
                "        'options': {\n" +
                "          'width': 300,\n" +
                "          'height': 300,\n" +
                "          'pieSliceText': 'value',\n" +
                "          'legend': 'right'\n" +
                "        }\n" +
                "      });\n" +
                "\n" +
                "      // Establish dependencies, declaring that 'filter' drives 'pieChart',\n" +
                "      // so that the pie chart will only display entries that are let through\n" +
                "      // given the chosen slider range.\n" +
                "      dashboard.bind(donutRangeSlider, pieChart);\n" +
                "\n" +
                "      // Draw the dashboard.\n" +
                "      dashboard.draw(data);\n" +
                "    }\n" +
                "  </script>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "  <!--Div that will hold the dashboard-->\n" +
                "  <div id=\"dashboard_div\">\n" +
                "    <!--Divs that will hold each control and chart-->\n" +
                "    <div id=\"filter_div\"></div>\n" +
                "    <div id=\"chart_div\"></div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        return text;
    }

    ;
}
