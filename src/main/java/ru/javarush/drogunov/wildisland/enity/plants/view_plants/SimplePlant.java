package ru.javarush.drogunov.wildisland.enity.plants.view_plants;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.plants.Plant;
import ru.javarush.drogunov.wildisland.game_space.Cell;

@UnitSetting(name = "Растения", icon = "\uD83C\uDF3F", weight = 1, maxPopulations = 200)
public class SimplePlant extends Plant {
    @Override
    public void multiply(Cell cell) {

    }

    /*public SimplePlant(int x, int y) {
        super(x, y);
    }*/
}
