package ru.javarush.drogunov.wildisland.enity.plants;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;

public abstract class Plant extends GameUnit implements Multiple {
    @Override
    public void multiply(Cell cell) {
        System.out.println("Plant multi " + Thread.currentThread().getName());
    }

    //TODO constructors

    /*public Plant(int x, int y) {
        super(x, y);
    }*/
}
