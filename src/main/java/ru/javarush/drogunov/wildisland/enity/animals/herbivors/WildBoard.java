package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;

@Populations(max = 50)
public class WildBoard extends GameUnit implements Actionable {
    public WildBoard() {
        super();
    }
/*  public WildBoard(int x, int y) {
        super(x, y);
    }*/
}
