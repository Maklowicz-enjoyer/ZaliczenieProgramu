package org.example;


import java.util.List;

public abstract class ShootingResult {
    protected DisciplineType type;

    public DisciplineType getType() {
        return type;
    }

    public abstract double getAverage();
    public abstract String getSummary();
}