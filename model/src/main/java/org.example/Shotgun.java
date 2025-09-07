package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shotgun extends ShootingResult{
    private List<Boolean> shots = new ArrayList<>();
    public Shotgun(List<Boolean> shots){
        this.type = DisciplineType.SHOTGUN;
        this.shots = shots;
    }



    @Override
    public double getAverage() {
        long countTrue = shots.stream().filter(b -> b).count();   // ile razy było true
        double average = (double) countTrue / shots.size();       // średnia w zakresie 0..1

        System.out.println("Liczba true: " + countTrue);
        System.out.println("Średnia true: " + average);
        return average;
    }

    @Override
    public String getSummary() {
        return String.format("Shotgun %.2f ", getAverage());
    }
}
