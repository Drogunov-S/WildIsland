package ru.javarush.drogunov.wildisland.servises;

import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.enity.animals.Animal;
import ru.javarush.drogunov.wildisland.enity.plants.Plant;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;

public class Worker implements Runnable {
    private final GameSpace gameSpace;
    private final int time = 1000;
    private final int countTact = 0;


    public Worker(GameSpace gameSpace) {
        this.gameSpace = gameSpace;
    }

    @Override
    public void run() {
        Cell[][] space = gameSpace.getSpace();
        for (Cell[] cells : space) {
            for (Cell cell : cells) {
                for (GameUnit gameUnit : cell.getGameUnitListOnCell()) {
                    if (gameUnit instanceof Animal animal) {
                        animal.eat(gameUnit, gameUnit);
                        animal.walk(cell, cell);
                        animal.multiply(cell);
                    } else {
                        Plant plant = (Plant) gameUnit;
                        plant.multiply(cell);
                    }
                }
            }
        }


    }
}
