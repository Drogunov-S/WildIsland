package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;

import java.util.Queue;
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
    public void run(){
        Thread.currentThread().setName(prototype.getSimpleName() + "-" + threadCount.incrementAndGet());
        try {

            gameMap.getSetUnits()
                    .stream()
                    .filter(gameUnit -> gameUnit.getClass() == prototype)
                    .forEach(gameUnit -> tasks.add(new Task(gameUnit)));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Whats wrong?");
            System.exit(999);
        }
    }

    //TODO ЭТО МЕТОДЫ ИСПОЛЬЗУЕМЫЕ В ПРИМЕРЕ, НО У МЕНЯ СОЗДАЕТСЯ МНОГО ПРИПАРКОВАННЫХ ТРЕДОВ
    // И ЮНИТ ВОРКЕРЫ СОЗДАЮТСЯ НЕ 1Н НА ВСЕХ ЮНИТОВ НА КАРТЕ ОПРЕДЕЛЕННОГО ТИПА
    // А НА ОПРЕДЕЛЕННОГО ТИПА В КАЖДОЙ ЯЧЕЙКЕ

    /*public void run() {
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
        if (allUnitsOnCell.size() == 0) {
            return;
        }
        cell.lockCell();
        try {
            allUnitsOnCell.forEach(gameUnit -> tasks.add(new Task(gameUnit, cell)));
        } finally {
            cell.unlockCell();
        }

        tasks.forEach(Task::toDo);
        tasks.clear();
    }*/
}
