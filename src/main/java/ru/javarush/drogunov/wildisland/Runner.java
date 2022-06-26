package ru.javarush.drogunov.wildisland;

import ru.javarush.drogunov.wildisland.enity.Game;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_space.GameSettings;
import ru.javarush.drogunov.wildisland.servises.GameWorker;
import ru.javarush.drogunov.wildisland.util.FactoryGameUnit;
import ru.javarush.drogunov.wildisland.util.MapFactory;
import ru.javarush.drogunov.wildisland.view.ConsoleView;
import ru.javarush.drogunov.wildisland.view.View;

public class Runner {
    public static void main(String[] args) {
        GameSettings gameSettings = new GameSettings();
        FactoryGameUnit factoryGameUnit = new FactoryGameUnit();
        MapFactory mapFactory = new MapFactory(factoryGameUnit, gameSettings);
        GameMap gameMap = mapFactory.createMapUnits();
        View view = new ConsoleView(gameMap);

        Game game = new Game(gameMap, factoryGameUnit, view);
        GameWorker gameWorker= new GameWorker(game);
        gameWorker.start();




       /* GameSettings gameSettings = new GameSettings();
        GameMap gameMap = new GameMap(gameSettings);
//        FabricGameUnit fabricGameUnit = new FabricGameUnit(); // статика

        StartPopulation startPopulation = new StartPopulation(gameMap);
        startPopulation.create();

        ConsoleView consoleView = new ConsoleView(gameMap);
        System.out.println(consoleView.showStatistics());

        *//*Thread thread = new Thread(new Worker(gameSpace));
        thread.start();
*//*

        Worker worker = new Worker(gameMap);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(worker);
        executorService.shutdown();

//        consoleView.showMap();*/
    }

/*//TODO удалить
    private static void count(Cell[][] space) {
        int wild = 0;
        int rabbit = 0;
        int cater = 0;
        int bear = 0;


        for (Cell[] cells : space) {
            for (Cell cell : cells) {
                List<GameUnit> gameUnitListOnCell = cell.getGameUnitListOnCell();
                for (GameUnit gameUnit : gameUnitListOnCell) {
//                    System.out.println(gameUnit.getId());
                    if (gameUnit.getClass().equals(Boar.class)) {
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
*/


}
