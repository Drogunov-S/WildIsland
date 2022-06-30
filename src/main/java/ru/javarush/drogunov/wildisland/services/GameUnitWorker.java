package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class GameUnitWorker implements Runnable {
    private boolean finished = false;
    private final AtomicInteger threadCount = new AtomicInteger(0);
    private final Class<?> prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedDeque<>();


    public GameUnitWorker(Class<?> prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override

    //TODO А В ТАКОМ ФОРМАТЕ СОЗДАЕТСЯ КУЧА МОНИТОРОВ И КАЖДОЕ ЖИВОТНОЕ СТАНОВИТСЯ МОНИТОРОМ
   /* public void run() {
        Thread.currentThread().setName(prototype.getSimpleName() + "-" + threadCount.incrementAndGet());
//        gameMap.lock();
        synchronized (gameMap) {
            try {
                Map<Cell, Map<String, Set<GameUnit>>> allUnits = gameMap.getAllUnits();
                allUnits.forEach((cell, mapUnitsOnGameMap) ->
                        mapUnitsOnGameMap
                                .forEach((name, setUnitsOnGameMap) -> setUnitsOnGameMap
                                        .stream()
                                        .filter(gameUnit -> gameUnit.getClass() == prototype)
                                        .forEach(gameUnit -> tasks.add(new Task(gameUnit, cell)))));
//        gameMap.unlock();

                tasks.forEach(Task::toDo);
                tasks.clear();

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Whats wrong?");
                System.exit(999);
//            gameMap.unlock();
            }
        }
    }*/

    //TODO ЭТО МЕТОДЫ ИСПОЛЬЗУЕМЫЕ В ПРИМЕРЕ, НО У МЕНЯ СОЗДАЕТСЯ МНОГО ПРИПАРКОВАННЫХ ТРЕДОВ
    // И ЮНИТ ВОРКЕРЫ СОЗДАЮТСЯ НЕ 1Н НА ВСЕХ ЮНИТОВ НА КАРТЕ ОПРЕДЕЛЕННОГО ТИПА
    // А НА ОПРЕДЕЛЕННОГО ТИПА В КАЖДОЙ ЯЧЕЙКЕ

    public void run() {
        Thread.currentThread().setName(prototype.getSimpleName() + "-" + threadCount.incrementAndGet());

        Cell[][] cells = gameMap.getSpace();
        countLiveCells(gameMap);
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

    }

    private void progressOnOneCell(Cell cell) {
        Set<GameUnit> allUnitsOnCell = cell.getUnitsMap().get(prototype.getSimpleName());
        if (allUnitsOnCell.size() == 0) {
            return;
        }
        cell.lockCell();
        try {
            allUnitsOnCell.forEach(gameUnit -> tasks.add(new Task(gameUnit, cell, gameMap)));
        } finally {
            cell.unlockCell();
        }

        tasks.forEach(Task::toDo);
        tasks.clear();


    }

    public boolean isFinished() {
        return finished;
    }

    private boolean countLiveCells(GameMap gameMap) {
        finished = gameMap.getSetUnits().size() == 0;
        return finished;
    }
}
