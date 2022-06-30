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
        decreaseForMultiply = gameUnit.getLimits().getMaxSatiety() * 0.3;
    }

    public void toDo() {
        //TODO зависаю после определенного цикла
        if (gameUnit instanceof Animal animal) {
            if (gameUnit.getSatiety() < 0) {
                gameUnit.saveDie(cell);
            }
            taskEat(animal);
//            animal.eat(cell);
            animal.walk(cell);
            gameUnit.subtractionSatiety(decreaseForWalk);
        }
        gameUnit.multiply(cell);
        gameUnit.subtractionSatiety(decreaseForMultiply);
    }

    private void taskEat(Animal eaterAnimal) {
        int count = 0;
        if (eaterAnimal.isFullSatiety()) {
            return;
        }
        TargetGameUnit target = gameMap.getTarget(gameUnit, cell);
        int probability = target.probability();
        do {
            if (Randomizer.getResult(probability)) {
                try {
                    GameUnit targetUnit = target.targetUnit();
                    cell.kickGameUnit(targetUnit);
                    eaterAnimal.eat(targetUnit);
                    count++;
                } catch (UnitTargetNotFoundException ignored) {
                    break;
                    //TODO тут так понимаю логирование
                }
                //TODO Что лучше было бы рекурсия или то что сделано do\while
            } /*else {
                taskEat(eaterAnimal);
            }*/
        } while (!eaterAnimal.isFullSatiety());
        if (count >= 2) {
            System.out.println(count + " ВСЕГО СЪЕДЕНО----------------------" + eaterAnimal.isFullSatiety()
                    + " " + eaterAnimal.getSatiety() + " " + eaterAnimal.getLimits().getMaxSatiety());
        }
    }

}
