package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Овца", icon = "\uD83D\uDC11", weight = 70, maxPopulations = 140, maxSteps = 3, satiety = 15)
public class Sheep extends Herbivores {
    public Sheep(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
