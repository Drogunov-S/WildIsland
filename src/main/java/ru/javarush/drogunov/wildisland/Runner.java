package ru.javarush.drogunov.wildisland;

import ru.javarush.drogunov.wildisland.enity.Game;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_space.GameSettings;
import ru.javarush.drogunov.wildisland.services.GameWorker;
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

        Game game = new Game(gameMap, view);
        GameWorker gameWorker= new GameWorker(game);
        gameWorker.start();
    }
}
