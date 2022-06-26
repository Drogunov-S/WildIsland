package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;

@FunctionalInterface
public interface Eating {
    void eat(Cell currentCell);
}
