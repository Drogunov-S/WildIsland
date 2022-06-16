package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.Cell;

//TODO Переименовать
public interface Actionable extends Multiple{
    void eat(GameUnit one, GameUnit two);

    void walk(Cell current, Cell target);
}
