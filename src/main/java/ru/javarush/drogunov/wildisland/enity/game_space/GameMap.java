package ru.javarush.drogunov.wildisland.enity.game_space;


import java.util.Arrays;

public class GameMap {
    private GameSettings gameSettings;
    private Cell[][] space;


    public GameMap(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        space = new Cell[gameSettings.getWidth()][gameSettings.getLength()];
    }

    public GameMap() {

    }


    public Cell[][] getSpace() {
        return space;
    }

    public Cell getCell(int x, int y) {
        return space[x][y];
    }


    @Override
    public String toString() {
        return Arrays.deepToString(space);



        /*StringBuilder str = new StringBuilder();
        for (Cell[] cells : space) {
            str.append( "|");
            for (Cell cell : cells) {
                str.append(" + ");
                Set<String> nameUnits = cell.nameUnitsOnCell();
                if (nameUnits == null) {
                    return "пусто";
                }
                for (String nameUnit : nameUnits) {
                    str.append(" ").append(nameUnit.substring(0, 3)).append(" ");
                }
                str.append(" + ");
                *//*List<GameUnit> gameUnitListOnCell = cell.getGameUnitListOnCell();
                if (gameUnitListOnCell.size() == 0) {
                    return "пусто";
                }
                for (GameUnit gameUnit : gameUnitListOnCell) {
                    String substring = gameUnit.getClass().getSimpleName().substring(0, 3);
                    str.append(" ").append(substring).append(" ");
                }*//*
            }
            str.append("|\n");
        }
        return str.toString();*/
    }
}
