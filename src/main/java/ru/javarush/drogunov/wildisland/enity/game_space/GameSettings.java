package ru.javarush.drogunov.wildisland.enity.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.annotations.Settings;

public class GameSettings {

    @Getter
    @Settings(code = 1, name = "Ширина игрового поля")
    private final int width = 100;

    @Getter
    @Settings(code = 2, name = "Длина игрового поля")
    private final int length = 20;
    //временно статик и паблик, не успел перенести в GameSetting
    @Getter
    @Settings(code = 3, name = "Максимальное время игры")
    private final static int gameTimeDays = 60;
}


