package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.game_space.Cell;

public interface Walkable {
    void walk(Cell current, Cell target);
}
