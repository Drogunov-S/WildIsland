package ru.javarush.drogunov.wildisland.enity.game_unit.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Утка", icon = "\uD83E\uDD86", weight = 1, maxPopulations = 220, maxSteps = 4, satiety = 0.15)
public class Duck extends Herbivores {
    public Duck(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
