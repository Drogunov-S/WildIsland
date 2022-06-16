package ru.javarush.drogunov.wildisland.game_space;

import ru.javarush.drogunov.wildisland.enity.GameUnit;

import java.util.List;

public class Cell {
    private static GameSpace gameSpace = GameSpace.getInstance();
    List<GameUnit> gameUnitListOnCell;


    private int x;

    private int y;

    public Cell(int x, int y, GameUnit gameUnit) {
        this.x = x;
        this.y = y;
        gameUnitListOnCell.add(gameUnit);
    }

    public Cell(int x, int y, List<GameUnit> gameUnit) {
        this.x = x;
        this.y = y;
        gameUnitListOnCell.addAll(gameUnit);
    }


    public int[] getPosition() {
        return new int[]{x, y};
    }

    public void addCell(GameUnit gameUnit) {
        gameUnitListOnCell.add(gameUnit);
    }
}
