package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
@FunctionalInterface
public interface Walkable {
    //TODO вообще не понятна данная ошибка, метод не используется в качестве лямбды?
    boolean walk(Cell current);
}

