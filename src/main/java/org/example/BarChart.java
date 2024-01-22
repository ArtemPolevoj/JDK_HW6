package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.HashMap;


public class BarChart extends JFrame {
    private final HashMap<String, Integer> result;
    private int count = 0;

    public BarChart(HashMap<String, Integer> result) {
        this.result = result;
        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() {

        var dataset = new DefaultCategoryDataset();

        for (String s : result.keySet()) {
            dataset.setValue(result.get(s), s, result.get(s));
            count = count + result.get(s);
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Monty hall paradox",
                "The number of cycles " + count,
                "Quantity",
                dataset,
                PlotOrientation.VERTICAL,
                true, false, false);
        barChart.addSubtitle(new TextTitle("The player chooses another door"));
        return barChart;
    }
}
