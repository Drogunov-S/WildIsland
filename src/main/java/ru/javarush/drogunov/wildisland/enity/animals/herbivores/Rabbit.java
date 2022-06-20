package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Кролик", icon = "\uD83D\uDC07", weight = 2, maxPopulations = 150, maxSteps = 2, satiety = 0.45)
public class Rabbit extends Herbivores {
    public Rabbit(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
