package ru.javarush.drogunov.wildisland.util;

import lombok.SneakyThrows;
import ru.javarush.drogunov.wildisland.Constants;
import ru.javarush.drogunov.wildisland.annotations.Populations;
import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;

import java.util.ArrayList;
import java.util.List;

public class FabricGameUnit {

@SneakyThrows
    public static List<GameUnit> getAllRandomCountGameUnit() {
        List<GameUnit> units = new ArrayList<>();
        for (Class unit : Constants.GAME_UNITS) {
            Populations declaredAnnotation = (Populations) unit.getDeclaredAnnotation(Populations.class);
            int count = Randomizer.getRandomInteger(declaredAnnotation.max());
            for (int i = 0; i < count; i++) {
                units.add((GameUnit) unit.getConstructor().newInstance());
            }
        }

        return units;
    }



}
