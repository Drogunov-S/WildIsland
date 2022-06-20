package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Коза", icon = "\uD83D\uDC10", weight = 60, maxPopulations = 140, maxSteps = 3, satiety = 10)
public class Goat extends Herbivores {
    public Goat(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
    /*public Goat(int x, int y) {
        super(x, y);
    }*/
}
