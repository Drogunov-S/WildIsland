package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

public class GameUnitWorker implements Runnable {

    private final Class<?> prototype;
    private final GameMap gameMap;

    private final Queue<Task> tasks = new ConcurrentLinkedDeque<>();

    public GameUnitWorker(Class<?> prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getSpace();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    progressOnOneCell(cell);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Что тут у нас?)) ");
                    System.exit(999);
                }


                //ver 1
       /* Cell[][] cells = gameMap.getSpace();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = prototype.getClass();
            *//*    cell.lockCell();
                try {
*//*
                    Set<GameUnit> gameUnits = cell.getMapGameUnits().get(type);
                    for (GameUnit gameUnit : gameUnits) {
                        gameUnit.multiply(cell);
                        if (gameUnit instanceof Animal animal) {
//                        animal.eat(cell);
//                        animal.walk(cell);
//
//
//                        Cell destination = animal.move(cell);
                            //animal.eat(destination);
                            //animal.spawn(destination);
                        } else {
//                        prototype.multiply(cell);
                        }
                    }
               *//* } finally {
                    cell.unlockCell();
                }*/
            }
        }
    }

    private void progressOnOneCell(Cell cell) {
        Set<GameUnit> allUnitsOnCell = cell.getUnitsMap().get(prototype.getSimpleName());
        cell.lockCell();

        try {
            allUnitsOnCell.forEach(typedUnit -> {
                Task task = new Task(typedUnit, unit -> {
                        unit.multiply(cell);
                        //TODO зависаю после определенного цикла
                if (unit instanceof Animal animal) {
//                            animal.eat(cell);
                            animal.walk(cell);
                }
                });
                    tasks.add(task);
        });
        } finally {
            cell.unlockCell();
        }

        tasks.forEach(Task::run);
        tasks.clear();
    }
}
