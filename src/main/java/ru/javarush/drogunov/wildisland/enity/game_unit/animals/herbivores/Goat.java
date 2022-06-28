package ru.javarush.drogunov.wildisland.enity.game_unit.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Коза", icon = "\uD83D\uDC10", weight = 60, maxPopulations = 140, maxSteps = 3, satiety = 10)
public class Goat extends Herbivores {
    public Goat(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
