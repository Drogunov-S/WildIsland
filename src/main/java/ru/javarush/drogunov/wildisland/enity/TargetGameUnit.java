package ru.javarush.drogunov.wildisland.enity;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.exceptions.UnitTargetNotFoundException;

public record TargetGameUnit(GameUnit targetUnit, int probability) {

    @Override
    public GameUnit targetUnit() {
        if (targetUnit == null) {
            throw new UnitTargetNotFoundException("Target units not found in cell");
        }
        return targetUnit;
    }
}
