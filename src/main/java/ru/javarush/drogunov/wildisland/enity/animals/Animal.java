package ru.javarush.drogunov.wildisland.enity.animals;

import lombok.Data;
import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.interfaces.Animalseble;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;

@Data
public abstract class Animal extends GameUnit implements Animalseble, Multiple, Eating {


    private int satiety;
    private int maxSteps;

    //TODO equals hashcode


    public Animal() {
//        id.getAndIncrement();
//        System.out.println("Конструктор" + toString());
    }


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
