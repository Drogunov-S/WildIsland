package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
@FunctionalInterface
public interface Walkable {
    boolean walk(Cell current);
}
