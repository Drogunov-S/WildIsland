package ru.javarush.drogunov.wildisland.enity.game_space;


import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameMap {
    private final Cell[][] space;


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

    @Override
    public String toString() {
        return Arrays.deepToString(space);
    }
}
