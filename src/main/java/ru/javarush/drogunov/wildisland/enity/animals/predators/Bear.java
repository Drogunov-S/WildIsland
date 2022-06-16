package ru.javarush.drogunov.wildisland.enity.animals.predators;

import ru.javarush.drogunov.wildisland.enity.animals.Animal;
import ru.javarush.drogunov.wildisland.enity.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Predatory;
@Populations(max = 5)
public class Bear extends Animal implements Predatory {

  /*  public Bear(int x, int y) {
        super(x, y);
    }*/
}
