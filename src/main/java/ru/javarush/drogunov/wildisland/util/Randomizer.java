package ru.javarush.drogunov.wildisland.util;

import java.util.Random;

public class Randomizer {
    public static int getRandomInteger(int to) {
        return new Random().nextInt(to);
    }
    public static int getRandomInteger(int from, int to) {
        return new Random().nextInt(from, to);
    }


}
