package ru.javarush.drogunov.wildisland.enity.game_unit.animals.predators;

import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
