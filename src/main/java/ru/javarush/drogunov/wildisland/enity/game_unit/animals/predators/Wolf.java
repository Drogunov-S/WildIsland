package ru.javarush.drogunov.wildisland.enity.game_unit.animals.predators;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Волк", icon = "\uD83D\uDC3A", weight = 50, maxPopulations = 30, maxSteps = 3, satiety = 8)
public class Wolf extends Predator {
    public Wolf(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
