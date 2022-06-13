package ru.javarush.drogunov.wildisland;

import ru.javarush.drogunov.wildisland.game_space.GameSpace;
import ru.javarush.drogunov.wildisland.util.InitializerGame;
import ru.javarush.drogunov.wildisland.util.Injector;

public class Runner {
    public static void main(String[] args) {

        InitializerGame initializerGame = (InitializerGame) Injector.injectDependencies(InitializerGame.class);
        System.out.println(GameSpace.getInstance());

    }


}
