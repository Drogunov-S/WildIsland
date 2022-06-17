package ru.javarush.drogunov.wildisland.enity.animals;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Animalseble;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;


public abstract class Animal
        extends GameUnit
        implements Animalseble, Multiple, Eating {

    private int satiety;
    private int maxSteps;

    @Override
    public void eat(GameUnit one, GameUnit two) {

    }

    @Override
    public void multiply(GameUnit one, GameUnit two) {

    }

    @Override
    public void walk(Cell current, Cell target) {

    }
}
