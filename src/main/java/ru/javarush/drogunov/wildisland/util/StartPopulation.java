/*
package ru.javarush.drogunov.wildisland.util;

import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;

public class StartPopulation {
    private GameSpace gameSpace = GameSpace.getInstance();


    //TODO закончил тут не работает инициализация мира
    public StartPopulation() {
        System.out.println("create");
        Cell[][] space = gameSpace.getSpace();
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                space[i][j] = new Cell(i, j, FabricGameUnit.getAllRandomCountGameUnit());
            }
        }




*/
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
        }*//*



    }

}
*/
//TODO удалить