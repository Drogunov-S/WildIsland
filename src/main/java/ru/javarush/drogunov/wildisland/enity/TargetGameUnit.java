package ru.javarush.drogunov.wildisland.enity;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.Objects;

public final class TargetGameUnit {
    private final GameUnit targetUnit;

    private final int probability;
    public TargetGameUnit(GameUnit targetUnit, int probability){
            this.targetUnit = targetUnit;
            this.probability = probability;
    }


    public GameUnit getTargetUnit() {
        return targetUnit;
    }

    public int getProbability() {
        return probability;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TargetGameUnit) obj;
        return Objects.equals(this.targetUnit, that.targetUnit) &&
                this.probability == that.probability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetUnit, probability);
    }

    @Override
    public String toString() {
        return "TargetGameUnit[" +
                "targetUnit=" + targetUnit + ", " +
                "probability=" + probability + ']';
    }

}
