package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;

public interface Walkable {
    void walk(Cell current, Cell target);
}
