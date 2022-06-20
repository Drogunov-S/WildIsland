package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@EqualsAndHashCode
@UnitSetting(name = "Лошадь", icon = "\uD83D\uDC0E", weight = 400, maxPopulations = 20, maxSteps = 4, satiety = 60)
public class Horse extends Herbivores {
    public Horse(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
    /*  public Horse(int x, int y) {
        super(x, y);
    }*/
}

