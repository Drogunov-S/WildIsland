package ru.javarush.drogunov.wildisland.enity;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
//TODO Что такое Record?
public class TargetGameUnit {
    private final GameUnit targetUnit;

    private final int probability;

    private boolean hasTarget = false;

    public TargetGameUnit(GameUnit targetUnit, int probability) {
        //TODO Возможно этот if не нужен.
        if (targetUnit == null) {
            targetUnit = null;
            probability = 0;
            hasTarget = false;
        }
        this.targetUnit = targetUnit;
        this.probability = probability;
        hasTarget = true;
    }
    public GameUnit getTargetUnit() {
        return targetUnit;
    }

    public int getProbability() {
        return probability;
    }

    public boolean hasTarget() {
        return hasTarget;
    }
}
