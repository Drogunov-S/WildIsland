package ru.javarush.drogunov.wildisland.enity.animals;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Animalseble;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;


public abstract class Animal
        extends GameUnit
        implements Animalseble, Multiple, Eating {

    private  int satiety;
    private  int maxSteps;


    @Override
    public void eat(GameUnit one, GameUnit two) {
        System.out.println("Animal eat " + Thread.currentThread().getName());



    }

    @Override
    public void multiply(Cell cell) {
        System.out.println("Animal multiply " + Thread.currentThread().getName());
    }

    @Override
    public void walk(Cell current, Cell target) {
        System.out.println("Animal walk " + Thread.currentThread().getName());
    }
}
