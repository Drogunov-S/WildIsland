package ru.javarush.drogunov.wildisland.enity.game_unit.animals.predators;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Орел", icon = "\uD83E\uDD85", weight = 6, maxPopulations = 20, maxSteps = 3, satiety = 1)
public class Eagle extends Predator {
    public Eagle(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
