package ru.javarush.drogunov.wildisland.util;

import lombok.SneakyThrows;
import ru.javarush.drogunov.wildisland.Constants;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;
import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;
import ru.javarush.drogunov.wildisland.exceptions.ClassNotInstanceException;
import ru.javarush.drogunov.wildisland.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FactoryGameUnit implements Factory {


    @Override
    public Cell createCell() {
        List<GameUnit> unitsOnCell = new ArrayList<>();
        for (Class<?> unit : Constants.GAME_UNITS.keySet()) {
            UnitSetting setting = unit.getDeclaredAnnotation(UnitSetting.class);
            String name = setting.name();
            String icon = setting.icon();
            double weight = setting.weight();
            int maxPopulation = setting.maxPopulations();
            Limits limit = new Limits(weight, maxPopulation, setting.maxSteps(), setting.satiety());
            Constructor<?> constructor = null;
            try {
                constructor = unit.getConstructor(String.class, String.class, double.class, Limits.class);
//                unitsOnCell.add(gameUnit);
                for (int i = 0; i < Randomizer.getRandomInteger(maxPopulation) - 1; i++) {
                    GameUnit gameUnit = (GameUnit) constructor.newInstance(name, icon, weight, limit);
                    unitsOnCell.add(gameUnit);
//TODO после переделки метода clone раскомментировать
//                    GameUnit clone = gameUnit.clone();

//                    unitsOnCell.add(clone);
                }
            } catch (NoSuchMethodException e) {
                throw new ConstructorNotFound("Constructor not found", e);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new ClassNotInstanceException("Class not instance", e);
            }
        }
        return new Cell(unitsOnCell);
    }

    //Этот метод был изначально для создания без параметров и конструктором по умолчанию.

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
