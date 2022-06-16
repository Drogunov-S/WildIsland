package ru.javarush.drogunov.wildisland.enity.animals.predators;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;

@Populations(max = 30)
public class Fox extends GameUnit implements Actionable {

  /*  public Fox(int x, int y) {
        super(x, y);
    }*/
}

