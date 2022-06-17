package ru.javarush.drogunov.wildisland.enity.plants.view_plants;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.plants.Plant;

@UnitSetting(name = "Растения", icon = "\uD83C\uDF3F", weight = 1, maxPopulations = 200)
public class SimplePlant extends Plant {
    @Override
    public void multiply(GameUnit one, GameUnit two) {

    }

    /*public SimplePlant(int x, int y) {
        super(x, y);
    }*/
}
