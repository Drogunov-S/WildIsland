package ru.javarush.drogunov.wildisland.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.enity.GameUnit;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Cell {
    private GameSpace gameSpace;
    @Getter
    private List<GameUnit> gameUnitListOnCell = new ArrayList<>(1000);
    private int x;
    private int y;




    public Cell(int x, int y, GameUnit gameUnit) {
        this.x = x;
        this.y = y;
        gameUnitListOnCell.add(gameUnit);
    }

    public Cell(int x, int y, List<GameUnit> gameUnit, GameSpace gameSpace) {
        this.x = x;
        this.y = y;
        this.gameSpace = gameSpace;
        gameUnitListOnCell.addAll(gameUnit);
    }


    public int[] getPosition() {
        return new int[]{x, y};
    }

    public void addCell(GameUnit gameUnit) {
        gameUnitListOnCell.add(gameUnit);
    }

    public Set<String> nameUnitsOnCell(){
        return getGameUnitListOnCell().stream().map(gameUnit -> gameUnit.getClass().getSimpleName()).collect(Collectors.toSet());
    }

    public Map<Type, Set<GameUnit>> getMapGameUnits() {
        Map<Type, Set<GameUnit>> result = new HashMap<>();
        for (GameUnit gameUnit : gameUnitListOnCell) {
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
        for (int i = 0; i < gameUnitListOnCell.size(); i++) {
            GameUnit gameUnit = gameUnitListOnCell.get(i);
            str.append(gameUnit.toString().substring(0,1));
        }
        str.append(" |\n");
        return str.toString();
    }
}
