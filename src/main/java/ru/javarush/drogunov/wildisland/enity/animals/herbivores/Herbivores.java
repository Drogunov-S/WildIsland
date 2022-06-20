package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.enity.Limits;
import ru.javarush.drogunov.wildisland.enity.animals.Animal;
public abstract class Herbivores extends Animal {

    public Herbivores(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
