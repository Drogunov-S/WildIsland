package ru.javarush.drogunov.wildisland;

import ru.javarush.drogunov.wildisland.enity.animals.herbivors.*;
import ru.javarush.drogunov.wildisland.enity.animals.predators.*;
import ru.javarush.drogunov.wildisland.enity.plants.view_plants.SimplePlant;

import java.util.HashSet;
import java.util.Set;

public class Constants {

    public static final Set<Class> GAME_UNITS = new HashSet<>();

    static {
        GAME_UNITS.add(Wolf.class);
        GAME_UNITS.add(Boa.class);
        GAME_UNITS.add(Fox.class);
        GAME_UNITS.add(Bear.class);
        GAME_UNITS.add(Eagle.class);
        GAME_UNITS.add(Horse.class);
        GAME_UNITS.add(Deer.class);
        GAME_UNITS.add(Rabbit.class);
        GAME_UNITS.add(Mouse.class);
        GAME_UNITS.add(Goat.class);
        GAME_UNITS.add(Sheep.class);
        GAME_UNITS.add(WildBoard.class);
        GAME_UNITS.add(Buffalo.class);
        GAME_UNITS.add(Duck.class);
        GAME_UNITS.add(Caterpillar.class);
        GAME_UNITS.add(SimplePlant.class);

    }
}
