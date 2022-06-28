package ru.javarush.drogunov.wildisland.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static int getRandomDouble(int to) {
        return ThreadLocalRandom.current().nextInt(to);
    }
    public static double getRandomDouble(double to) {
        return ThreadLocalRandom.current().nextDouble(to);
    }

    public static boolean getResult(int probability) {
        return ThreadLocalRandom.current().nextInt(0,100) <= probability;
    }
}
