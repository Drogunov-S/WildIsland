package ru.javarush.drogunov.wildisland.enity.animals.predators;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Удав", icon = "\uD83D\uDC0D", weight = 15, maxPopulations = 40, maxSteps = 1, satiety = 3)
public class Boa extends Predator {
    public Boa(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}

