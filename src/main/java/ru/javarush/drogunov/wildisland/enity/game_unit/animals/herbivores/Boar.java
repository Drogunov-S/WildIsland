package ru.javarush.drogunov.wildisland.enity.game_unit.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;

@UnitSetting(name = "Кабан", icon = "\uD83D\uDC03", weight = 400, maxPopulations = 50, maxSteps = 2, satiety = 50)
public class Boar extends Herbivores {
    public Boar(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
