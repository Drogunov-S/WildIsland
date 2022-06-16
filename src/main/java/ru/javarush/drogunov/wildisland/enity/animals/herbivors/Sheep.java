package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.enity.animals.Animal;
import ru.javarush.drogunov.wildisland.enity.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Herbivorous;

@Populations(max = 140)
public class Sheep extends Animal implements Herbivorous {

   /* public Sheep(int x, int y) {
        super(x, y);
    }*/
}
