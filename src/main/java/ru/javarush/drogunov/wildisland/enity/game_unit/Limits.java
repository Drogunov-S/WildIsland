package ru.javarush.drogunov.wildisland.enity.game_unit;

public class Limits {
    private final double maxWeight;
    private final int maxPopulation;
    private final int maxSteps;
    private final double maxSatiety;

    private double weight;

    private int steps;
    private double satiety;
    public Limits(double maxWeight, int maxPopulation, int maxSteps, double maxSatiety) {
        this.maxWeight = maxWeight;
        this.maxPopulation = maxPopulation;
        this.maxSteps = maxSteps;
        this.maxSatiety = maxSatiety;
    }

    public double getWeight() {
        return weight;
    }

    public int getSteps() {
        return steps;
    }

    public double getSatiety() {
        return satiety;
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

    public double getMaxSatiety() {
        return maxSatiety;
    }
}
