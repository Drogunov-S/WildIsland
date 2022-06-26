package ru.javarush.drogunov.wildisland.enity.game_unit.animals;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Walkable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import static ru.javarush.drogunov.wildisland.Constants.PROBABILITY_EATING;


public abstract class Animal
        extends GameUnit
        implements Walkable, Eating {

    public Animal(String name, String icon, double weight, Limits limits) {
        super(name, icon, weight, limits);
    }


    @Override
    public void eat(Cell currentCell) {
        Lock lock = currentCell.getLock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {

            Map<Class<?>, Integer> targetUnits = PROBABILITY_EATING.get(this.getClass());
            List<GameUnit> gameUnitList = currentCell.getGameUnitList();

            for (var pair : targetUnits.entrySet()) {
                Class<?> target = pair.getKey();
                Iterator<GameUnit> iterator1 = gameUnitList.iterator();
                while (iterator1.hasNext()) {
                    GameUnit next = iterator1.next();
                    //TODO включить вероятность съедания
                    if (next.getClass() == target) {
//                        if (Randomizer.getResult(pair.getValue())) {
                        iterator1.remove();
                        break;
//                        }
                    }
                }

            }
        } finally {
            currentCell.unlockCell();
        }
    }

    /*public void eat(Cell currentCell) {
        currentCell.lockCell();

        try {

//        System.out.println("Поел " + Thread.currentThread().getName());
            Map<Class<?>, Integer> targetUnits = PROBABILITY_EATING.get(this.getClass());
            Map<Type, Set<GameUnit>> unitsOnMap = currentCell.getMapGameUnits();


            int countUnits = 0;

            for(var pair : targetUnits.entrySet()) {
                Class<?> key = pair.getKey();
                Integer value = pair.getValue();
                Set<GameUnit> set = unitsOnMap.get(key);
                countUnits += set.size();
                if (set != null) {
                    Iterator<GameUnit> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        if (Randomizer.getRandomInteger() <= value) {
                            iterator.remove();
                        }
                    }
                    System.out.print(countUnits);
                }
            }
        } finally {
            currentCell.unlockCell();
        }
    }*/

    @Override
    public void multiply(Cell currentCell) {
        while (currentCell.getLock().tryLock())

        try {
            GameUnit partner = currentCell.getPair(this);
            if (partner != null) {
                currentCell.getGameUnitList().add(this.clone(this));
            }

        } finally {
            currentCell.unlockCell();
        }

        /*currentCell.lockCell();
        try {

//        System.out.println("размножился животное " + getName()+ " " + Thread.currentThread().getName());
            Map<Type, Set<GameUnit>> mapGameUnits = currentCell.getMapGameUnits();
            Set<GameUnit> set = mapGameUnits.get(this.getClass());
            if (set != null) {
                if (currentCell.getCountPopulations(this) < this.getLimits().getMaxPopulation()) {
                    GameUnit next = set.iterator().next();
                    Animal clone = this.clone(this);
                    currentCell.addCell(clone);
                }
            }
        } finally {
            currentCell.unlockCell();;
        }*/
    }

    @Override
    public void walk(Cell currentCell) {
        currentCell.lockCell();
        try {
            currentCell.getGameUnitList().remove(this);
        } finally {
            currentCell.unlockCell();
        }

        Cell nextCell = currentCell.getNextCell(this.getLimits().getMaxSteps());
        nextCell.lockCell();

        try {
            nextCell.getGameUnitList().add(this);
        } finally {
            nextCell.unlockCell();
        }

    }
}
