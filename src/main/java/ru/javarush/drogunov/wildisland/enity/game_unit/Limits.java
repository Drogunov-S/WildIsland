package ru.javarush.drogunov.wildisland.enity.game_unit;

public class Limits {
    private static final double PERCENT_FOR_MULTIPLY = 20;
    private final double maxWeight;
    private final int maxPopulation;
    private final int maxSteps;
    private final double maxSatiety;
//Да я знаю что это колхоз в лимитах хранить и максимум и текущее состояние
    private double weight;
    private double satiety;

    public Limits(double maxWeight, int maxPopulation, int maxSteps, double maxSatiety) {
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

    public double getMaxSatiety() {
        return maxSatiety;
    }

}
