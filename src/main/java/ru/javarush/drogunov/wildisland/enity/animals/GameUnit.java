package ru.javarush.drogunov.wildisland.enity.animals;

import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;

public abstract class GameUnit implements Actionable, Multiple {
    private String viewAnimal;
    private int weight;
    private int satiety;
    private int maxSteps;

   /* public Animal(int x, int y) {
        super(x, y);
    }*/

    @Override
    public void eat(GameUnit one, GameUnit two) {

    }

    @Override
    public void multiply(GameUnit one, GameUnit two) {

    }

    @Override
    public void walk(Cell current, Cell target) {

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
//TODO иквелс и хэшкод
}
