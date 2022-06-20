package ru.javarush.drogunov.wildisland.servises;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;
import ru.javarush.drogunov.wildisland.enity.game_unit.plants.Plant;
import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;

public class Worker implements Runnable {
    private final GameMap gameMap;
    private final int time = 1000;
    private final int countTact = 0;


    public Worker(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] space = gameMap.getSpace();
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
