package ru.javarush.drogunov.wildisland.enity;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public abstract class GameUnit {

    //clone
 //tostring
    private static final AtomicLong idcur = new AtomicLong(System.currentTimeMillis());
    private final long id = idcur.incrementAndGet();
    private String icon;
    private double weight;

}
