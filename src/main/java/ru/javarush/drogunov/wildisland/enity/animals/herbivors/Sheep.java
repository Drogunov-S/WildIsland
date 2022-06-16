package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;

@Populations(max = 140)
public class Sheep extends GameUnit implements Actionable {

   /* public Sheep(int x, int y) {
        super(x, y);
    }*/
}
