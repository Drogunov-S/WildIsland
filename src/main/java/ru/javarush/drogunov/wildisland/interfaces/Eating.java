package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

@FunctionalInterface
public interface Eating {
    @SuppressWarnings("unused")
    void eat(GameUnit gameUnit);
}
