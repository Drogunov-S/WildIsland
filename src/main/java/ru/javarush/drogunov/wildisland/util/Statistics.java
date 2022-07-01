package ru.javarush.drogunov.wildisland.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
    private static final AtomicInteger countDead = new AtomicInteger();
    private static final AtomicInteger countDeadOfHanger = new AtomicInteger();
    private static final AtomicInteger countHaveBeenEaten = new AtomicInteger();
    private static final AtomicInteger countMultiply = new AtomicInteger();

    private static final AtomicInteger days = new AtomicInteger();


    public static int getCountAllDead() {
        countDead.setRelease(countDeadOfHanger.get() + countHaveBeenEaten.get());
        return countDead.get();
    }

    public static void incrementCountMultiply() {
        countMultiply.incrementAndGet();
    }

    public static int gatCountMultiply() {
        return countMultiply.get();
    }

    public static void incrementCountDeadOfHanger() {
        countDeadOfHanger.incrementAndGet();
    }

    public static int getCountDeadOfHanger() {
        return countDeadOfHanger.get();
    }

    public static void incrementCountHaveBeenEaten() {
        countHaveBeenEaten.incrementAndGet();
    }

    public static int getCountHaveBeenEaten() {
        return countHaveBeenEaten.get();
    }

    public static int incrementCountDays() {
       return days.incrementAndGet();
    }

    public static int getCountDays() {
        return days.get();
    }

}
