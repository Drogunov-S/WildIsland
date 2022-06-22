package ru.javarush.drogunov.wildisland.enity.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Cell {
    private GameMap gameMap;
    @Getter
    private List<GameUnit> gameUnitList = new ArrayList<>(1000);
    private int x;
    private int y;




    public Cell(int x, int y, GameUnit gameUnit) {
        this.x = x;
        this.y = y;
        gameUnitList.add(gameUnit);
    }

    public Cell(int x, int y, List<GameUnit> gameUnit, GameMap gameMap) {
        this.x = x;
        this.y = y;
        this.gameMap = gameMap;
        gameUnitList.addAll(gameUnit);
    }


    public Cell(List<GameUnit> unitsOnCell) {
        gameUnitList = unitsOnCell;

    }

    public Set<GameUnit> getSetUnits() {
    return new HashSet<>(gameUnitList);
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public void addCell(GameUnit gameUnit) {
        gameUnitList.add(gameUnit);
    }

    public Set<String> nameUnitsOnCell(){
        return getGameUnitList().stream().map(gameUnit -> gameUnit.getClass().getSimpleName()).collect(Collectors.toSet());
    }

    public Map<Type, Set<GameUnit>> getMapGameUnits() {
        Map<Type, Set<GameUnit>> result = new HashMap<>();
        for (GameUnit gameUnit : gameUnitList) {
            Class<? extends GameUnit> aClass = gameUnit.getClass();
            if (!result.containsKey(aClass)) {
                result.put(aClass, new HashSet<>(Set.of(gameUnit)));
                continue;
            }
            result.get(aClass).add(gameUnit);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("| ");
        for (int i = 0; i < gameUnitList.size(); i++) {
            GameUnit gameUnit = gameUnitList.get(i);
            str.append(gameUnit.toString().substring(0,1));
        }
        str.append(" |\n");
        return str.toString();
    }
}
