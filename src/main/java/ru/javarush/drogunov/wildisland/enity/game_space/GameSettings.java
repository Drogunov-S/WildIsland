package ru.javarush.drogunov.wildisland.enity.game_space;

import lombok.Getter;
import ru.javarush.drogunov.wildisland.annotations.Settings;

public class GameSettings {
    private GameSettings gameSettings;



    @Getter
    @Settings(code = 1, name = "Ширина игрового поля")
    private int width = 30;//100

    @Getter
    @Settings(code = 2, name = "Длина игрового поля")
    private int length = 10;//20

    @Settings(code = 3, name = "Максимальное время игры")
    private int gameTime = 0;
}


