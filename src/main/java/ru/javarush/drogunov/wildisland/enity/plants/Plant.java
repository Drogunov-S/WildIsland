package ru.javarush.drogunov.wildisland.enity.plants;
import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.interfaces.Vegetable;

public abstract class Plant extends GameUnit implements Vegetable {

    public Plant(int x, int y) {
        super(x, y);
    }
}
