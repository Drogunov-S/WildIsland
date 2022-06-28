package ru.javarush.drogunov.wildisland.enity.game_unit.animals.herbivores;

import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@EqualsAndHashCode
@UnitSetting(name = "Лошадь", icon = "\uD83D\uDC0E", weight = 400, maxPopulations = 20, maxSteps = 4, satiety = 60)
public class Horse extends Herbivores {
    public Horse(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}

