package ru.javarush.drogunov.wildisland.enity.animals;

import ru.javarush.drogunov.wildisland.enity.PlaySpace;
import ru.javarush.drogunov.wildisland.interfaces.Animalble;
import ru.javarush.drogunov.wildisland.interfaces.Essences;

public abstract class Animal implements Animalble, Essences {
    private String viewAnimal;
    private int weight;
    private int satiety;
    private int maxSteps;

    @Override
    public void eat(Animal one, Animal two) {

    }

    @Override
    public void multiply(Animal one, Animal two) {

    }

    @Override
    public void walk(PlaySpace playSpace) {

    }
}
