package ru.javarush.drogunov.wildisland.servises;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;

import java.lang.reflect.Type;
import java.util.Set;

public class GameUnitWorker implements Runnable {

    private final GameUnit prototype;
    private final GameMap gameMap;

    public GameUnitWorker(GameUnit prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getSpace();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = prototype.getClass();
                Set<GameUnit> gameUnits = cell.getMapGameUnits().get(type);
                for (GameUnit gameUnit : gameUnits) {
                    if (gameUnit instanceof Animal animal) {
                        animal.eat();
                        animal.walk(cell);
//                        Cell destination = animal.move(cell);
                        //animal.eat(destination);
                        //animal.spawn(destination);
                    } else {
                        prototype.multiply(cell);
                    }
                }
            }
        }
    }
}
