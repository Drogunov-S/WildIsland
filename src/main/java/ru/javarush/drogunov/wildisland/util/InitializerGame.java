package ru.javarush.drogunov.wildisland.util;

import ru.javarush.drogunov.wildisland.enity.annotations.Initialize;
import ru.javarush.drogunov.wildisland.game_space.GameSettings;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;

public class InitializerGame {
    @Initialize
    GameSettings gameSettings;
    @Initialize
    GameSpace gameSpace;
    @Initialize
    StartPopulation startPopulation;




}
