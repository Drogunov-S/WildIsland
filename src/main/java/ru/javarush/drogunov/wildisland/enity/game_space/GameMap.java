package ru.javarush.drogunov.wildisland.enity.game_space;


import ru.javarush.drogunov.wildisland.enity.TargetGameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ru.javarush.drogunov.wildisland.Constants.PROBABILITY_EATING;

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

    public int getSizeAlive() {
        lock();
        int size = getSetUnits().size();
        unlock();
        return size;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

//TODO в targetUnits хранится вероятность съедания, но согласно ООП как я его понимаю, GameMap
//    не может знать о вероятности съедания так как это бизнес логика,
//    Вопрос: Откуда мне нужно было вернуть цифру вероятности для Task, так как она необходима в ней
//    Как раз в Task я стараюсь разместить всю бизнес логику?
//    Вероятный ответ: GameMap может знать о типах Юнитов или тянуть вероятность съедания с настроек?

    public TargetGameUnit getTarget(GameUnit eater, Cell cell) {
        Map<Class<?>, Integer> targetUnits = PROBABILITY_EATING.get(eater.getClass());

        for (var pair : targetUnits.entrySet()) {
            String simpleName = pair
                    .getKey()
                    .getSimpleName();
            Integer probability = pair.getValue();
            GameUnit target = cell.getTarget(simpleName);
            return new TargetGameUnit(target, probability);
        }
        return null;
    }

}
