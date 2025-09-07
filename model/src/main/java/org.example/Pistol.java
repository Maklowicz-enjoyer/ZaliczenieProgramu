package org.example;


import java.util.ArrayList;
import java.util.List;

public class Pistol extends ShootingResult {
    private List<Integer> shots = new ArrayList<>();

    public Pistol(List<Integer> shots) {
        this.type = DisciplineType.PISTOL;
        this.shots = shots;
    }

    @Override
    public double getAverage() {
        return shots.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public String getSummary() {
        return String.format("Pistolet: %.2f", getAverage());
    }
}
