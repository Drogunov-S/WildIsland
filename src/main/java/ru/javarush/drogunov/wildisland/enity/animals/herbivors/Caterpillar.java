package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;

@Populations(max = 1000)
public class Caterpillar extends GameUnit implements Actionable {

   /* public Caterpillar(int x, int y) {
        super(x, y);
    }*/
}
