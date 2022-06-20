package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Мышь", icon = "\uD83D\uDC01", weight = 0.5, maxPopulations = 500, maxSteps = 1, satiety = 0.01)
public class Mouse extends Herbivores {
    public Mouse(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }


    /*public Mouse(int x, int y) {
        super(x, y);
    }*/
}
