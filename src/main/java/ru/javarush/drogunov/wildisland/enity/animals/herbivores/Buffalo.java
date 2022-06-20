package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Буйвол", icon = "\uD83D\uDC17", maxPopulations = 20, satiety = 100, maxSteps = 3, weight = 700)
public class Buffalo extends Herbivores {

    public Buffalo(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
