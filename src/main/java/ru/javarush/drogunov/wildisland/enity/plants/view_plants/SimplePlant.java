package ru.javarush.drogunov.wildisland.enity.plants.view_plants;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.enity.plants.Plant;

@Populations(max = 200)
public class SimplePlant extends Plant {
    @Override
    public void multiply(GameUnit one, GameUnit two) {

    }

    /*public SimplePlant(int x, int y) {
        super(x, y);
    }*/
}
