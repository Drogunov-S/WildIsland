package ru.javarush.drogunov.wildisland.enity.game_unit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.exceptions.CloneUnitException;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;
import ru.javarush.drogunov.wildisland.util.Randomizer;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Data

@EqualsAndHashCode
public abstract class GameUnit implements Cloneable, Multiple {

    private static final AtomicLong indicator = new AtomicLong(System.currentTimeMillis());
    private long id = indicator.incrementAndGet();

    private final String type = this.getClass().getSimpleName();

    private final String name;
    private final String icon;
    private double weight;
    private Limits limits;

    public GameUnit(String name, String icon, double weight, Limits limits) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limits = limits;
    }

    public String getType() {
        return type;
    }

    public GameUnit(GameUnit gameUnit) {
        //TODO сделать рандомный вес
        this(gameUnit.getName(),
                gameUnit.getIcon(),
                gameUnit.getWeight(),
                gameUnit.getLimits());
    }

    @Override
    public String toString() {
        return (/*name + " " + */icon);
        //TODO Вопрос тут вместо конкатенации лучше было бы использовать StringBuilder??
    }


    @Override
    public void multiply(Cell cell) {
//        System.out.println("размножился " + name + Thread.currentThread().getName());
//        if (this instanceof Plant) {
        cell.lockCell();
        try {
            if (cell.isMaxPopulation(this)) {
                GameUnit clone = this.clone(this);
                cell.getUnitsMap().get(getType()).add(clone);
            }
        } finally {
            cell.unlockCell();
        }

    }

    @Override
    protected GameUnit clone() throws CloneNotSupportedException {
        GameUnit clone = (GameUnit) super.clone();
        clone.id = indicator.incrementAndGet();
        clone.weight = Randomizer.getRandomInteger(clone.weight);
        return clone;
    }

    public <T extends GameUnit> T clone(T unit) {
        try {
            return (T) unit.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneUnitException("don't cloned", e);
        }
    }

    public boolean saveDie(Cell cell) {
        cell.lockCell();
        try {
            Set<GameUnit> set = cell.getUnitsMap().get(this.getType());
            set.remove(this);
            if (!set.contains(this)) {
                System.out.println("удален");
                return true;
            }
        } finally {
            cell.unlockCell();
        }

        return false;

    }


}
