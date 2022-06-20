package ru.javarush.drogunov.wildisland.enity.game_unit.animals;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;
import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Animalseble;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;


public abstract class Animal
        extends GameUnit
        implements Animalseble, Multiple, Eating {

    public Animal(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }

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
