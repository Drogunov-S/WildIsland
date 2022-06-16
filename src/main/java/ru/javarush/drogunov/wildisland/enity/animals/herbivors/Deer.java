package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;
@Populations(max = 20)
public class Deer extends GameUnit implements Actionable {

   /* public Deer(int x, int y) {
        super(x, y);
    }*/
}
