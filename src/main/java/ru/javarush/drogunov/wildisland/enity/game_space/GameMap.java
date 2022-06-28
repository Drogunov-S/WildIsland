package ru.javarush.drogunov.wildisland.enity.game_space;


import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GameMap {
    private final Cell[][] space;
    private final Lock lock = new ReentrantLock(true);


    public GameMap(GameSettings gameSettings) {
        int width = gameSettings.getWidth();
        int length = gameSettings.getLength();
        space = new Cell[width][length];
    }


    public int getCountLine() {
        return space.length;
    }

    public int getCountColum() {
        return space[0].length;
    }

    public Cell[][] getSpace() {
        return space;
    }

    public Set<GameUnit> getSetUnits() {
        Set<GameUnit> setUnitsOnGameMap = new HashSet<>();
        Arrays.stream(space)
                .forEach(lines -> Arrays.stream(lines)
                        .forEach(cell -> cell.getUnitsMap()
                                .values()
                                .forEach(setUnitsOnGameMap::addAll)));
        return setUnitsOnGameMap;
    }

    public Map<Cell, Map<String, Set<GameUnit>>> getAllUnits() {
        Map<Cell, Map<String, Set<GameUnit>>> allUnits = new HashMap<>();
        Arrays.stream(space)
                .forEach(cells ->
                        Arrays.stream(cells)
                                .forEach(cell -> {
                                    Map<String, Set<GameUnit>> mapUnitsOnCell = cell.getUnitsMap();
                                    if (allUnits.containsKey(cell)) {
                                        Map<String, Set<GameUnit>> stringGameUnitMap = allUnits.get(cell);
                                        mapUnitsOnCell.forEach((name, unitsOnCell) -> {
                                            if (stringGameUnitMap.containsKey(name)) {
                                                stringGameUnitMap.get(name).addAll(mapUnitsOnCell.get(name));
                                            }
                                        });
                                    } else {
                                        allUnits.put(cell, mapUnitsOnCell);
                                    }
                                }));
        return allUnits;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(space);
    }


    public void lock() {
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }
}
