package ru.javarush.drogunov.wildisland.enity.game_unit.animals;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Walkable;
import ru.javarush.drogunov.wildisland.util.Randomizer;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static ru.javarush.drogunov.wildisland.Constants.PROBABILITY_EATING;


public abstract class Animal
        extends GameUnit
        implements Walkable, Eating {


    public Animal(String name, String icon, Limits limits) {
        super(name, icon, limits);
        super.satiety = Randomizer.getRandom(limits.getMaxSatiety());
    }


    @Override
    public boolean eat(Cell cell) {
        if (satiety < 0) {
            saveDie(cell);
            return false;
        }
        cell.lockCell();
        try {
            Map<Class<?>, Integer> targetUnits = PROBABILITY_EATING.get(this.getClass());
            Map<String, Set<GameUnit>> gameUnitList = cell.getUnitsMap();

            for (var pair : targetUnits.entrySet()) {
                Class<?> target = pair.getKey();
                Iterator<GameUnit> iterator1 = gameUnitList.get(target.getSimpleName()).iterator();
                while (iterator1.hasNext()) {
                    GameUnit next = iterator1.next();
                    //TODO включить вероятность съедания
                    if (next.getClass() == target) {
                        if (Randomizer.getResult(pair.getValue())) {
                            System.out.println("Съел " + getName() + " " + getId());
//                                saveDie(cell);
                            iterator1.remove();
                            return true;
                        }
                    }
                }
            }
        } finally {
            cell.unlockCell();
        }
        return false;
    }

    public boolean isFullSatiety() {
        return this.satiety == limits.getMaxSatiety();
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
    public boolean multiply(Cell cell) {
        if (satiety < 0) {
            saveDie(cell);
            return false;
        }
        cell.lockCell();
        try {
//            System.out.println(getName() + " multi");
            if (cell.isMaxPopulation(this)) {
                GameUnit partner = cell.getPair(this);
                if (partner != null) {
                    GameUnit clone = partner.clone(this);
                    cell.getUnitsMap().get(getType()).add(clone);
                    return true;
                }
            }
        } finally {
            cell.unlockCell();
        }
        return false;
    }

    @Override
    public boolean walk(Cell cell) {
        if (satiety < 0) {
            saveDie(cell);
            return false;
        }
        cell.lockCell();
        try {
            cell.getUnitsMap().get(getType()).remove(this);
        } finally {
            cell.unlockCell();
        }

        Cell nextCell = cell.getNextCell(this.getLimits().getMaxSteps());
        if (satiety < 0) {
            saveDie(cell);
            return false;
        }

        nextCell.lockCell();
        try {
            nextCell.getUnitsMap().get(getType()).add(this);
        } finally {
            nextCell.unlockCell();
        }
        return true;
    }
}
