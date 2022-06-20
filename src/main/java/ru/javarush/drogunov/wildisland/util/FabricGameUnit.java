package ru.javarush.drogunov.wildisland.util;

import lombok.SneakyThrows;
import ru.javarush.drogunov.wildisland.Constants;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.GameUnit;

import java.util.ArrayList;
import java.util.List;

public class FabricGameUnit {

    @SneakyThrows
    public static List<GameUnit> getAllRandomCountGameUnit() {
        List<GameUnit> units = new ArrayList<>();
        for (Class unit : Constants.GAME_UNITS.keySet()) {
            UnitSetting settings = (UnitSetting) unit.getDeclaredAnnotation(UnitSetting.class);
            int count = Randomizer.getRandomInteger(settings.maxPopulations());
            for (int i = 0; i < count; i++) {
                units.add((GameUnit) unit.getConstructor().newInstance());
            }
        }

        return units;
    }


}
