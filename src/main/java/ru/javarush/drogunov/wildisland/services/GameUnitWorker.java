package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class GameUnitWorker implements Runnable {

    private final AtomicInteger threadCount = new AtomicInteger(0);

    private final Class<?> prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedDeque<>();

    public GameUnitWorker(Class<?> prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(prototype.getSimpleName() + "-" + threadCount.incrementAndGet());

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
            }
        }
//        System.out.println(gameMap.getSetUnits().size());
    }

    private void progressOnOneCell(Cell cell) {
        Set<GameUnit> allUnitsOnCell = cell.getUnitsMap().get(prototype.getSimpleName());
        if (allUnitsOnCell.size() == 0){
            return;
        }

        cell.lockCell();
//232479
        try {
            allUnitsOnCell.forEach(typedUnit -> {
                Task task = new Task(typedUnit, unit -> {
                    //TODO зависаю после определенного цикла
                    if (unit instanceof Animal animal) {
                        animal.eat(cell);
                        animal.walk(cell);
                    }
                    unit.multiply(cell);
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
