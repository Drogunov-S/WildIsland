package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;
@EqualsAndHashCode
@Populations(max = 20)
public class Horse extends GameUnit implements Actionable {

  /*  public Horse(int x, int y) {
        super(x, y);
    }*/
}

