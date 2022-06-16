package ru.javarush.drogunov.wildisland.enity.animals.predators;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;

@Populations(max = 5)
public class Bear extends GameUnit implements Actionable {

  /*  public Bear(int x, int y) {
        super(x, y);
    }*/
}
