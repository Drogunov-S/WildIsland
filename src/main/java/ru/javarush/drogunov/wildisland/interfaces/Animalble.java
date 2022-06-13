package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.enity.PlaySpace;
import ru.javarush.drogunov.wildisland.enity.animals.Animal;

public interface Animalble {
    void eat(Animal one, Animal two);

    void multiply(Animal one, Animal two);

    void walk(PlaySpace playSpace);
}
