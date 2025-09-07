package org.example;


import java.util.ArrayList;
import java.util.List;
public class Rifle extends ShootingResult{

    private List<Integer> shots = new ArrayList<>();

    public Rifle(List<Integer> shots){
        this.type = DisciplineType.RIFLE;
        this.shots = shots;
    }

    public double getAverage(){
        return shots.stream().mapToInt(Integer::intValue).average().orElse(0);
    }


    @Override
    public String getSummary() {
        return String.format("Rifle %.2f ", getAverage());
    }
}
