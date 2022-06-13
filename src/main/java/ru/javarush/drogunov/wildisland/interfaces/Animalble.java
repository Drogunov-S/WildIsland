package ru.javarush.drogunov.wildisland.interfaces;

import ru.javarush.drogunov.wildisland.game_space.GameSpace;
import ru.javarush.drogunov.wildisland.enity.animals.Animal;

public interface Animalble {
    void eat(Animal one, Animal two);

    void multiply(Animal one, Animal two);

    void walk(GameSpace playSpace);
}
