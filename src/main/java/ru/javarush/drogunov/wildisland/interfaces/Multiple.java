package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;

@SuppressWarnings("ALL")
@FunctionalInterface
public interface Multiple {
    boolean multiply(Cell cell);
}
