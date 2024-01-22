package org.example;

import java.awt.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String nameWin = "WIN";
        String nameLoss = "LOSS";
        int count = 1000;
        int win = 0;
        int loss = 0;
        MontyHallParadox montyHallParadox = new MontyHallParadox(nameWin, nameLoss, count);
        HashMap<Integer, String> result = montyHallParadox.getResults();
        HashMap<String, Integer> counts = new HashMap<>();

        for (Integer i : result.keySet())
            if (result.get(i).equals(nameWin)) {
                win++;
            } else if (result.get(i).equals(nameLoss)) {
                loss++;
            }

        counts.put(nameWin, win);
        counts.put(nameLoss, loss);
        EventQueue.invokeLater(() -> {
            var barChart = new BarChart(counts);
            barChart.setVisible(true);
        });
    }
}