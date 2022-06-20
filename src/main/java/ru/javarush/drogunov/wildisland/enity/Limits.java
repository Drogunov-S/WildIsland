package ru.javarush.drogunov.wildisland.enity;

public class Limits {
    private final double maxWeight;
    private final int maxPopulation;

    private final int maxSteps;

    private final int maxSatiety;

    public Limits(double maxWeight, int maxPopulation, int maxSteps, int maxSatiety) {
        this.maxWeight = maxWeight;
        this.maxPopulation = maxPopulation;
        this.maxSteps = maxSteps;
        this.maxSatiety = maxSatiety;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public int getMaxSatiety() {
        return maxSatiety;
    }
}
