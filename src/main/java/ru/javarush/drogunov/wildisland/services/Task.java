package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;

public class Task {

    private final GameUnit gameUnit;
    private final Cell cell;

    private final double decreaseForWalk;
    private final double decreaseForMultiply;


    public Task(GameUnit gameUnit, Cell cell) {
        this.gameUnit = gameUnit;
        this.cell = cell;
        decreaseForWalk = gameUnit.getLimits().getMaxSatiety() * 0.3;
        decreaseForMultiply = gameUnit.getLimits().getMaxSatiety() * 0.5;

    }

    public void toDo() {
        //TODO зависаю после определенного цикла
        if (gameUnit instanceof Animal animal) {
            if (gameUnit.getSatiety() < 0) {
                gameUnit.saveDie(cell);
            }
            animal.eat(cell);
            animal.walk(cell);
            gameUnit.minusSatiety(decreaseForWalk);
        }
        gameUnit.multiply(cell);
        gameUnit.minusSatiety(decreaseForMultiply);
    }
}
