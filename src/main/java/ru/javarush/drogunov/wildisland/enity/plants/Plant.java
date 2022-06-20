package ru.javarush.drogunov.wildisland.enity.plants;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.enity.Limits;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;

public abstract class Plant extends GameUnit implements Multiple {


    public Plant(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }

    @Override
    public void multiply(Cell cell) {
        System.out.println("Plant multi " + Thread.currentThread().getName());
    }

}
