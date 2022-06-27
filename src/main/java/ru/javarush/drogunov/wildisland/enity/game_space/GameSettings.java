package ru.javarush.drogunov.wildisland.enity.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.annotations.Settings;

public class GameSettings {
    private GameSettings gameSettings;

//TODO При большей карте все виснет

    @Getter
    @Settings(code = 1, name = "Ширина игрового поля")
    private int width = 10;//100

    @Getter
    @Settings(code = 2, name = "Длина игрового поля")
    private int length = 5;//20
//временно статик и паблик
    @Settings(code = 3, name = "Максимальное время игры")
    public static int gameTime = 10;
}


