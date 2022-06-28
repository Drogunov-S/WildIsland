package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;

public class Task {

    private final GameUnit gameUnit;
    private final Cell cell;

    public Task(GameUnit gameUnit, Cell cell) {
        this.gameUnit = gameUnit;
        this.cell = cell;
    }

    public void toDo() {
        //TODO зависаю после определенного цикла
        if (gameUnit instanceof Animal animal) {
            animal.eat(cell);
            animal.walk(cell);
        }
        gameUnit.multiply(cell);
    }
}
