package ru.javarush.drogunov.wildisland.enity.animals;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.enity.PlaySpace;
import ru.javarush.drogunov.wildisland.interfaces.Animalble;

public abstract class Animal extends GameUnit implements Animalble {
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

    //TODO иквелс и хэшкод
}
