package ru.javarush.drogunov.wildisland.enity.animals.predators;

import ru.javarush.drogunov.wildisland.enity.Limits;
import ru.javarush.drogunov.wildisland.enity.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
