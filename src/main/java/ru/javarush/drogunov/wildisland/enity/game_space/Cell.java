package ru.javarush.drogunov.wildisland.enity.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.util.Randomizer;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Lock lock = new ReentrantLock(true);

    @Getter
    private final List<Cell> nextCell = new ArrayList<>();

    public Map<String, Set<GameUnit>> getUnitsMap() {
        return unitsOnCell;
    }

    private final Map<String, Set<GameUnit>> unitsOnCell = new HashMap<>() {
        private void checkNull(Object key) {
            this.putIfAbsent(key.toString(), new HashSet<>());
        }

        @Override
        public Set<GameUnit> get(Object key) {
            checkNull(key);
            return super.get(key);
        }

        @Override
        public Set<GameUnit> put(String key, Set<GameUnit> value) {
            checkNull(key);
            return super.put(key, value);
        }
    };


    public void linkedCells(GameMap gameMap, int line, int colum) {
        Cell[][] space = gameMap.getSpace();
        if (line > 0) {
            nextCell.add(space[line - 1][colum]);
        }
        if (colum > 0) {
            nextCell.add(space[line][colum - 1]);
        }
        if (line < gameMap.getCountLine() - 1) {
            nextCell.add(space[line + 1][colum]);
        }
        if (colum < gameMap.getCountColum() - 1) {
            nextCell.add(space[line][colum + 1]);
        }
    }

    public Cell getNextCell(int maxSteps) {
        Cell cell = nextCell.get(Randomizer.getRandom(nextCell.size()));
        if (maxSteps == 0) {
            return cell;
        }
        return getNextCell(maxSteps - 1);
    }

    public boolean isMaxPopulation(GameUnit gameUnit) {
        Set<GameUnit> set = unitsOnCell.get(gameUnit.getType());
        int size = set.size();
        return size <= gameUnit
                .getLimits()
                .getMaxPopulation();
    }


    public GameUnit getPair(GameUnit unit) {
        Set<GameUnit> set = unitsOnCell.get(unit.getType());
        if (set == null || set.size() < 1) {
            return null;
        }
        for (GameUnit gameUnit : set) {
            if (unit != gameUnit) {
                return gameUnit;
            }
        }
        return null;
    }

    public void lockCell() {
        lock.lock();
    }

    public void unlockCell() {
        lock.unlock();
    }

    public GameUnit getTarget(String nameTargetUnit) {
        lockCell();
        try {
            Set<GameUnit> setTargetUnits = unitsOnCell.get(nameTargetUnit);
            if (setTargetUnits.size() == 0) {

                //TODO А вообще нужна ли такая ошибка?
                // И где ее обрабатывать в GameMap или выше.
                // Я ее бросание ошибки добавил в TargetGameUnit при значении null, комментарии оставил хочу совет
                // строки 105 111 оставил специально
//                throw new UnitTargetNotFoundException("Target not found");
            }
            GameUnit targetUnit = setTargetUnits.stream()
                    .filter(GameUnit::isAccess)
                    .findAny()
                            .orElseGet(() -> null);
//                    .orElseThrow(() -> new UnitTargetNotFoundException("All units don't access"));
            return targetUnit == null ? null : targetUnit.saveGet();
        } finally {
            unlockCell();
        }
    }

    public void kickGameUnit(GameUnit targetUnit) {
        lockCell();
        String simpleName = targetUnit.getClass().getSimpleName();
        unitsOnCell.get(simpleName).remove(targetUnit);
        lock.unlock();
    }
}
