package ru.javarush.drogunov.wildisland.game_settings;

import ru.javarush.drogunov.wildisland.enity.animals.herbivors.*;
import ru.javarush.drogunov.wildisland.enity.animals.predators.*;
import ru.javarush.drogunov.wildisland.enity.plants.view_plants.SimplePlant;

import java.util.HashMap;
import java.util.Map;

public class EssencesOnTheIsland {
    private final Map<Object, Integer> standardMaxCount = new HashMap<>();


    public EssencesOnTheIsland() {
        standardMaxCount.put(Wolf.class, 30);
        standardMaxCount.put(Boa.class, 30);
        standardMaxCount.put(Fox.class, 30);
        standardMaxCount.put(Bear.class, 5);
        standardMaxCount.put(Eagle.class, 20);
        standardMaxCount.put(Horse.class, 20);
        standardMaxCount.put(Deer.class, 20);
        standardMaxCount.put(Rabbit.class, 150);
        standardMaxCount.put(Mouse.class, 500);
        standardMaxCount.put(Goat.class, 140);
        standardMaxCount.put(Sheep.class, 140);
        standardMaxCount.put(WildBoard.class, 50);
        standardMaxCount.put(Buffalo.class, 20);
        standardMaxCount.put(Duck.class, 200);
        standardMaxCount.put(Caterpillar.class, 1000);
        standardMaxCount.put(SimplePlant.class, 200);
    }

    public int getMaxCount(Object object) {
        return standardMaxCount.get(object.getClass());
    }


}
