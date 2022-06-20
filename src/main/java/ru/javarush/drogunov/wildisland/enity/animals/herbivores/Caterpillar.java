package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Гусеница", icon = " \uD83D\uDC1B", maxPopulations = 1000, satiety = 100, weight = 0.01)
public class Caterpillar extends Herbivores {
    public Caterpillar(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
