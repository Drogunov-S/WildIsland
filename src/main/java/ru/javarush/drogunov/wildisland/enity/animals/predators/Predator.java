package ru.javarush.drogunov.wildisland.enity.animals.predators;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.enity.animals.Animal;
import ru.javarush.drogunov.wildisland.game_space.Cell;

public abstract class Predator extends Animal {
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
