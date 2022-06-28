package ru.javarush.drogunov.wildisland.enity.game_unit.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Кролик", icon = "\uD83D\uDC07", weight = 2, maxPopulations = 150, maxSteps = 2, satiety = 0.45)
public class Rabbit extends Herbivores {
    public Rabbit(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
