package ru.javarush.drogunov.wildisland.enity.game_unit.animals.predators;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Лиса", icon = "\uD83E\uDD8A", weight = 8, maxPopulations = 30, maxSteps = 2, satiety = 2)
public class Fox extends Predator {
    public Fox(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}

