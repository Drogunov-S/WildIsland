package ru.javarush.drogunov.wildisland.enity.game_unit.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Олень", icon = "\uD83E\uDD8C", weight = 300, maxPopulations = 20, maxSteps = 4, satiety = 50)
public class Deer extends Herbivores {
    public Deer(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
