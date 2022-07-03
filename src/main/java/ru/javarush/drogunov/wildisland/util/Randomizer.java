package ru.javarush.drogunov.wildisland.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static int getRandom(int to) {
        if (to == 0) {
            return 0;
        }

        return ThreadLocalRandom.current().nextInt(to);
    }

    public static double getRandom(double to) {
        if (to == 0) {
            return 0.0;
        }
        return ThreadLocalRandom.current().nextDouble(to);
    }

    public static boolean getResult(int probability) {
        return ThreadLocalRandom.current().nextInt(0, 100) <= probability;
    }
}
