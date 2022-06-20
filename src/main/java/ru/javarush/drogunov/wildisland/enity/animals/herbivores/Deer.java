package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.Limits;

@UnitSetting(name = "Олень", icon = "\uD83E\uDD8C", weight = 300, maxPopulations = 20, maxSteps = 4, satiety = 50)
public class Deer extends Herbivores {
    public Deer(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }
}
