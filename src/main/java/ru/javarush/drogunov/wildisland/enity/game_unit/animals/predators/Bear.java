package ru.javarush.drogunov.wildisland.enity.game_unit.animals.predators;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Медведь", icon = "\uD83D\uDC3B", weight = 500, maxPopulations = 5, maxSteps = 2, satiety = 80)
public class Bear extends Predator {
    public Bear(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
