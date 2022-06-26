package ru.javarush.drogunov.wildisland.util;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_space.GameSettings;

public class MapFactory {
    private Factory factory;
    private GameSettings gameSettings;


    public MapFactory(FactoryGameUnit factoryGameUnit, GameSettings gameSettings) {
        this.factory = factoryGameUnit;
        this.gameSettings = gameSettings;
    }


    public GameMap createMapUnits() {
        GameMap gameMap = new GameMap(gameSettings);
        Cell[][] space = gameMap.getSpace();
        for (int i = 0; i < space.length; i++) {
            Cell[] cells = space[i];
            for (int j = 0; j < cells.length; j++) {
                Cell cell = factory.createCell();
                space[i][j] = cell;
            }
        }
        createLinkedCells(gameMap);
        return gameMap;
    }

    private void createLinkedCells(GameMap gameMap) {
        Cell[][] space = gameMap.getSpace();
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                space[i][j].linkedCells(gameMap, i, j);
            }
        }
    }
    /*public void create() {
        Cell[][] space = gameMap.getSpace();
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                space[i][j] = new Cell(i, j, FactoryGameUnit.getAllRandomCountGameUnit(), gameMap);
            }
        }
    }*/
}



/*

        for (Class aClass : Constants.GAME_UNITS) {
            Populations declaredAnnotation = (Populations) aClass.getDeclaredAnnotation(Populations.class);
            if (aClass.isAnnotationPresent(Populations.class)) {
                for (int i = 0; i < space.length; i++) {
                    for (int t = 0; t < space[i].length; t++) {
                        for (int j = 0; j < Randomizer.getRandomInteger(declaredAnnotation.max()); j++) {
//                            space[i][t] = aClass.getConstructor().newInstance(i, t);
                        }
                    }
                }
            }
        }



    }

}
*/
