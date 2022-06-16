package ru.javarush.drogunov.wildisland;

import ru.javarush.drogunov.wildisland.game_space.GameSettings;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;
import ru.javarush.drogunov.wildisland.util.StartPopulation;
import ru.javarush.drogunov.wildisland.view.ConsoleView;

public class Runner {
    public static void main(String[] args) {
        GameSettings gameSettings = new GameSettings();
        GameSpace gameSpace = new GameSpace(gameSettings);
//        FabricGameUnit fabricGameUnit = new FabricGameUnit(); // статика
        StartPopulation startPopulation = new StartPopulation(gameSpace);
        startPopulation.create();
        ConsoleView consoleView = new ConsoleView(gameSpace);
        consoleView.showMap();
        consoleView.showStatistics();


//        System.out.println(gameSpace);

    }


}
