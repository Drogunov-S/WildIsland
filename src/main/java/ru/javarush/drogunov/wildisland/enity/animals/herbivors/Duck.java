package ru.javarush.drogunov.wildisland.enity.animals.herbivors;

import ru.javarush.drogunov.wildisland.enity.animals.Animal;
import ru.javarush.drogunov.wildisland.enity.annotations.Populations;
import ru.javarush.drogunov.wildisland.interfaces.Herbivorous;

@Populations(max = 200)
public class Duck extends Animal implements Herbivorous {

   /* public Duck(int x, int y) {
        super(x, y);
    }*/
}
