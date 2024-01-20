package org.example;

import java.util.HashMap;
import java.util.Random;

public class MontyHallParadox {
    private final HashMap<Integer, String> results = new HashMap<>();
    private  final String nameWin;
    private  final String nameLoss;
    private final int count;

    public MontyHallParadox(String nameWin, String nameLoss, int count) {
        this.nameWin = nameWin;
        this.nameLoss = nameLoss;
        this.count = count;
    }

    public HashMap<Integer, String> getResults(){
        setResults();
        return results;
    }

    private void setResults() {

        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            int prizeDoor = random.nextInt(3);
            int selectedDoor = random.nextInt(3);
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == prizeDoor || revealedDoor == selectedDoor);

            int switchedDoor;
            do {
                switchedDoor = random.nextInt(3);
            } while (switchedDoor == selectedDoor || switchedDoor == revealedDoor);

            boolean prize = switchedDoor == prizeDoor;

            if (prize) {
                results.put(i, nameWin);
            } else {
                results.put(i, nameLoss);
            }
        }
    }
}
