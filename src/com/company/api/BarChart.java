package com.company.api;

import com.company.gui.Question1Controller;
import com.company.gui.Question2Controller;
import com.company.gui.Question3Controller;
import com.company.gui.Question4Controller;
import com.company.services.Test;

public class BarChart {
    public static String barChartHTML(){
        return "<html>\n" +
                "  <head>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "      google.charts.load('current', {'packages':['bar']});\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "      function drawChart() {\n" +
                "        var data = google.visualization.arrayToDataTable([\n" +
                "          ['Personality Trait', 'trait 1', 'trait 2'],\n" +
                "          ['Extroversion vs Introversion', "+ Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 1) +", "+Test.countNumbers(Question1Controller.extrovertVsIntrovertAnswersStorage, 0)+"],\n" +
                "          ['Sensing vs Intuition', "+Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 1)+", "+Test.countNumbers(Question2Controller.sensingVsIntuitionsAnswersStorage, 0)+"],\n" +
                "          ['Thinking vs Feeling', "+ Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 1)+", "+Test.countNumbers(Question3Controller.thinkingVsFeelingAnswersStorage, 0) +"],\n" +
                "          ['Judging Perceiving', "+Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 1)+ ", "+Test.countNumbers(Question4Controller.judgingVsPerceivingAnswersStorage, 0)+"]\n" +
                "        ]);\n" +
                "\n" +
                "        var options = {\n" +
                "          chart: {\n" +
                "            title: 'Company Performance',\n" +
                "            subtitle: 'Sales, Expenses, and Profit: 2014-2017',\n" +
                "          },\n" +
                "          bars: 'horizontal' // Required for Material Bar Charts.\n" +
                "        };\n" +
                "\n" +
                "        var chart = new google.charts.Bar(document.getElementById('barchart_material'));\n" +
                "\n" +
                "        chart.draw(data, google.charts.Bar.convertOptions(options));\n" +
                "      }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"barchart_material\" style=\"width: 400px; height: 300px;\"></div>\n" +
                "  </body>\n" +
                "</html>\n";
    };
}
