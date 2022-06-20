package ru.javarush.drogunov.wildisland.enity;

import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.util.Factory;
import ru.javarush.drogunov.wildisland.view.View;


public class Game {

    private final GameMap gameMap;
    private final Factory factory;
    private final View view;

    public Game(GameMap gameMap, Factory factory, View view) {
        this.gameMap = gameMap;
        this.factory = factory;
        this.view = view;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Factory getFactory() {
        return factory;
    }

    public View getView() {
        return view;
    }
}
