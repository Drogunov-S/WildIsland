package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.enity.animals.Animal;
import ru.javarush.drogunov.wildisland.enity.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Herbivorous;

@Populations(max = 1000)
public class Caterpillar extends Animal implements Herbivorous {

   /* public Caterpillar(int x, int y) {
        super(x, y);
    }*/
}
