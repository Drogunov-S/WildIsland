package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.TargetGameUnit;
import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.animals.Animal;
import ru.javarush.drogunov.wildisland.exceptions.UnitTargetNotFoundException;
import ru.javarush.drogunov.wildisland.util.Randomizer;

public class Task {

    private final GameUnit gameUnit;
    private final Cell cell;
    private final GameMap gameMap;

    private final double decreaseForWalk;
    private final double decreaseForMultiply;


    public Task(GameUnit gameUnit, Cell cell, GameMap gameMap) {
        this.gameUnit = gameUnit;
        this.cell = cell;
        this.gameMap = gameMap;
        decreaseForWalk = gameUnit.getLimits().getMaxSatiety() * 0.3;
        decreaseForMultiply = gameUnit.getLimits().getMaxSatiety() * 0.5;
    }

    public void toDo() {
        //TODO зависаю после определенного цикла
        if (gameUnit instanceof Animal animal) {
            if (gameUnit.getSatiety() < 0) {
                gameUnit.saveDie(cell);
            }
            taskEat(animal);
//            animal.eat(cell);
//            animal.walk(cell);
//            gameUnit.minusSatiety(decreaseForWalk);
        }
//        gameUnit.multiply(cell);
//        gameUnit.minusSatiety(decreaseForMultiply);
    }

    private boolean taskEat(Animal eaterAnimal) {
        TargetGameUnit target = gameMap.getTarget(gameUnit, cell);
        if (!target.hasTarget()) {
            return false;
        }
        if (eaterAnimal.getSatiety() >= eaterAnimal.getLimits().getMaxSatiety()) {
            return true;
        }
        int probability = target.getProbability();
        if (Randomizer.getResult(probability)) {
            try {
                GameUnit targetUnit = target.getTargetUnit();
                cell.kickGameUnit(targetUnit);
                eaterAnimal.eat(targetUnit);
            } catch (UnitTargetNotFoundException e) {
                return false;
            }
        }
        return false;
    }

}
