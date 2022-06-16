package ru.javarush.drogunov.wildisland.enity.animals;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;
import ru.javarush.drogunov.wildisland.interfaces.Animalble;

public abstract class Animal extends GameUnit implements Animalble {
    private String viewAnimal;
    private int weight;
    private int satiety;
    private int maxSteps;

   /* public Animal(int x, int y) {
        super(x, y);
    }*/

    @Override
    public void eat(Animal one, Animal two) {

    }

    @Override
    public void multiply(Animal one, Animal two) {

    }

    @Override
    public void walk(GameSpace playSpace) {

    }

    //TODO иквелс и хэшкод
}
