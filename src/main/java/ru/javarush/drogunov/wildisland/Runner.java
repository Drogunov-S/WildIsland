package ru.javarush.drogunov.wildisland;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.enity.animals.herbivors.Caterpillar;
import ru.javarush.drogunov.wildisland.enity.animals.herbivors.Rabbit;
import ru.javarush.drogunov.wildisland.enity.animals.herbivors.WildBoard;
import ru.javarush.drogunov.wildisland.enity.animals.predators.Bear;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.game_space.GameSettings;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;
import ru.javarush.drogunov.wildisland.util.StartPopulation;
import ru.javarush.drogunov.wildisland.view.ConsoleView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        GameSettings gameSettings = new GameSettings();
        GameSpace gameSpace = new GameSpace(gameSettings);
//        FabricGameUnit fabricGameUnit = new FabricGameUnit(); // статика
        StartPopulation startPopulation = new StartPopulation(gameSpace);
        startPopulation.create();
        ConsoleView consoleView = new ConsoleView(gameSpace);
        consoleView.showStatistics();
        Cell[][] space = gameSpace.getSpace();
        count(space);


//        System.out.println(gameSpace);

    }

    private static void count(Cell[][] space) {
        int wild = 0;
        int rabbit = 0;
        int cater = 0;
        int bear = 0;


        for (Cell[] cells : space) {
            for (int i = 0; i < cells.length; i++) {
                Cell cell = cells[i];
                List<GameUnit> gameUnitListOnCell = cell.getGameUnitListOnCell();
                for (GameUnit gameUnit : gameUnitListOnCell) {
//                    System.out.println(gameUnit.getId());
                    if (gameUnit.getClass().equals(WildBoard.class)) {
                        wild++;
                    }
                    if (gameUnit.getClass().equals(Rabbit.class)) {
                        rabbit++;
                    }
                    if (gameUnit.getClass().equals(Caterpillar.class)) {
                        cater++;
                    }
                    if (gameUnit.getClass().equals(Bear.class)) {
                        bear++;
                    }
                }
            }
        }

        System.out.printf("w%d r%d c%d b%d",wild, rabbit, cater,bear);

    }


}
