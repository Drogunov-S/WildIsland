package ru.javarush.drogunov.wildisland.game_space;


public class GameSpace {
    private GameSpace gameSpace;

    public Cell[][] getSpace() {
        return space;
    }

    public Cell getCell(int x, int y) {
        return space[x][y];
    }

    private Cell[][] space;

    public GameSpace() {
        getInstance();
    }

    private GameSpace(GameSettings gameSettings) {
        int x = GameSettings.getInstance().getWidth();
        int y = GameSettings.getInstance().getLength();
        space = new Cell[x][y];
    }

    public static GameSpace getInstance() {
        System.out.println("game space");
        if (gameSpace == null) {
            gameSpace = new GameSpace(GameSettings.getInstance());
            return gameSpace;
        }
        return gameSpace;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Cell[] cells : space) {
            for (Cell cell : cells) {
                if (cell == null) {
                    return "| пусто |";
                }
                str.append("| "+ cell.gameUnitListOnCell  + " |");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
