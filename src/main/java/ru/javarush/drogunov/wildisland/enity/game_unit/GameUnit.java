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

    protected volatile double satiety;
    protected double weight;
    protected Limits limits;

    public GameUnit(String name, String icon, Limits limits) {
        this.name = name;
        this.icon = icon;
        this.limits = limits;
        this.weight = Randomizer.getRandomDouble(limits.getMaxWeight());
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return (name + " " + icon);
        //TODO Вопрос тут вместо конкатенации лучше было бы использовать StringBuilder??
    }


    @Override
    public boolean multiply(Cell cell) {
//        System.out.println("размножился " + name + Thread.currentThread().getName());
//        if (this instanceof Plant) {
        cell.lockCell();
        try {
            if (cell.isMaxPopulation(this)) {
                GameUnit clone = this.clone(this);
                cell.getUnitsMap().get(getType()).add(clone);
                return true;
            }
        } finally {
            cell.unlockCell();
        }
        return false;
    }

    @Override
    protected GameUnit clone() throws CloneNotSupportedException {
        GameUnit clone = (GameUnit) super.clone();
        clone.id = indicator.incrementAndGet();
        return clone;
    }

    @SuppressWarnings("I'm don't undestend whats to do it")
    public <T extends GameUnit> T clone(T unit) {
        try {
            T clone = (T) unit.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new CloneUnitException("don't cloned", e);
        }
    }

    @SuppressWarnings("Method will be use future")
    public boolean saveDie(Cell cell) {
        cell.lockCell();
        try {
            Set<GameUnit> set = cell.getUnitsMap().get(this.getType());
            set.remove(this);
//            }
        } finally {
            cell.unlockCell();
        }

        return false;

    }

    public void minusSatiety(double howMany) {
        satiety -= howMany;
    }


}
