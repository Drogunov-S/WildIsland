package ru.javarush.drogunov.wildisland.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
    //TODO да можно сделать не статикой) осталось до 14:00 не много времени)
    private static final AtomicInteger days = new AtomicInteger();
    private static final AtomicInteger countDeadAll = new AtomicInteger();
    private static int countDeadLastDay = 0;
    private static final AtomicInteger countHaveBeenEatenAll = new AtomicInteger();
    private static int countHaveBeenEatenLastDay = 0;
    private static final AtomicInteger countDeadOfHangerAll = new AtomicInteger();
    private static int countDeadOfHangerLastDay = 0;
    private static final AtomicInteger countMultiplyAll = new AtomicInteger();
    private static int countMultiplyLastDay = 0;

    public static int getCountDays() {
        return days.get();
    }


    public static int getCountDeadAll() {
        countDeadAll.setRelease(countDeadOfHangerAll.get() + countHaveBeenEatenAll.get());
        return countDeadAll.get();
    }

    public static int getCountDeadDay() {
        return getCountDeadAll() - countDeadLastDay;
    }

    public static int getCountHaveBeenEatenAll() {
        return countHaveBeenEatenAll.get();
    }

    public static int getCountHaveBeenEatenDay() {
        return getCountHaveBeenEatenAll() - countHaveBeenEatenLastDay;
    }

    public static int getCountDeadOfHangerAll() {
        return countDeadOfHangerAll.get();
    }

    public static int getCountDeadOfHangerDay() {
        return getCountDeadOfHangerAll() - countDeadOfHangerLastDay;
    }

    public static int getCountMultiplyAll() {
        return countMultiplyAll.get();
    }

    public static int getCountMultiplyDay() {
        return getCountMultiplyAll() - countMultiplyLastDay;
    }

    public static int incrementCountDays() {
        return days.incrementAndGet();
    }

    public static void incrementCountHaveBeenEaten() {
        countHaveBeenEatenAll.incrementAndGet();
    }

    public static void incrementCountDeadOfHanger() {
        countDeadOfHangerAll.incrementAndGet();
    }

    public static void incrementCountMultiply() {
        countMultiplyAll.incrementAndGet();
    }

    public static void updateDataOfDay() {
        countDeadLastDay = getCountDeadAll();
        countHaveBeenEatenLastDay = getCountHaveBeenEatenAll();
        countDeadOfHangerLastDay = getCountDeadOfHangerAll();
        countMultiplyLastDay = getCountMultiplyAll();
    }

}
