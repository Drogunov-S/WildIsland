package ru.javarush.drogunov.wildisland.enity.animals.herbivores;

import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
@EqualsAndHashCode
@UnitSetting(name = "Утка", icon = "", weight = 1, maxPopulations = 220, maxSteps = 4, satiety = 0.15)
public class Duck extends Herbivores {


   /* public Duck(int x, int y) {
        super(x, y);
    }*/
}
