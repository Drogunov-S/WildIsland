package ru.javarush.drogunov.wildisland.enity.game_unit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.exceptions.CloneUnitException;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;

import java.util.concurrent.atomic.AtomicLong;

@Data
@EqualsAndHashCode
public abstract class GameUnit implements Cloneable, Multiple {

    private static final AtomicLong indicator = new AtomicLong(System.currentTimeMillis());
    private final long id = indicator.incrementAndGet();
    private final String name;
    private final String icon;
    private double weight;
    private Limits limits;

    public GameUnit(String name, String icon, double weight, Limits limits) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limits = limits;
    }

    /*public GameUnit(GameUnit gameUnit) {

    }*/

    @Override
    public String toString() {
        return name + " " + icon;

        //Это был первый вариант и он работал, но решил убрать так как RAPI тяжелое
        /*UnitSetting annotation = getClass().getAnnotation(UnitSetting.class);
        //TODO Вопрос тут вместо конкатенации лучше было бы использовать StringBuilder??
        return annotation.name() + " " + annotation.icon();*/

    }

    @Override
    public GameUnit clone() {
        //TODO переделать на поверхностное клонирование
        try {
            return (GameUnit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneUnitException("Cannot clone " + this, e);
        }
    }
}
