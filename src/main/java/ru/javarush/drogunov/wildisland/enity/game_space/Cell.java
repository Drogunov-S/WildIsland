package ru.javarush.drogunov.wildisland.enity.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.util.Randomizer;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Cell {
    private final Lock lock = new ReentrantLock(true);

    @Getter
    private volatile List<GameUnit> gameUnitList;
    private List<Cell> nextCell = new ArrayList<>();


    public Cell(List<GameUnit> unitsOnCell) {
        gameUnitList = unitsOnCell;

    }

    public Set<GameUnit> getSetUnits() {
        return new HashSet<>(gameUnitList);
    }


    public void addCell(GameUnit gameUnit) {
        gameUnitList.add(gameUnit);
    }

    public Lock getLock() {
        return lock;
    }

    public Set<String> nameUnitsOnCell() {
        return getGameUnitList().stream().map(gameUnit -> gameUnit.getClass().getSimpleName()).collect(Collectors.toSet());
    }

    public Map<Type, Set<GameUnit>> getMapGameUnits() {

        Map<Type, Set<GameUnit>> result = new HashMap<>();
            for (GameUnit gameUnit : gameUnitList) {
                Class<? extends GameUnit> aClass = gameUnit.getClass();
                if (!result.containsKey(aClass)) {
                    HashSet<GameUnit> typeUnits = new HashSet<>();
                    typeUnits.add(gameUnit);
                    result.put(aClass, typeUnits); // не работал из за Set.of?
                    continue;
                }
                result.get(aClass).add(gameUnit);
            }
        return result;
    }

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
        Cell cell = nextCell.get(Randomizer.getRandomInteger(nextCell.size()));
        if (maxSteps == 0) {
            return cell;
        }
        return getNextCell(maxSteps - 1);
    }

 /*   private Set<Cell> getVisitedCell(int maxSteps){
        if (maxSteps == 0) {
            return new HashSet<>().add(this);
        }
        Set<Cell> visitedCells = new HashSet<>();
        nextCell.stream()
                .filter()

    }*/

    public int getCountPopulations(GameUnit gameUnit) {
        return (int) gameUnitList.stream()
                .filter(unit -> unit.getClass() == gameUnit.getClass())
                .count();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("| ");
        for (int i = 0; i < gameUnitList.size(); i++) {
            GameUnit gameUnit = gameUnitList.get(i);
            str.append(gameUnit.toString().substring(0, 1));
        }
        str.append(" |\n");
        return str.toString();
    }

    public GameUnit getPair(GameUnit unit) {
        for (GameUnit gameUnit : gameUnitList) {
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
}
