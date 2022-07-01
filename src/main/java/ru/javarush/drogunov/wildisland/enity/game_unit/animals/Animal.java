package ru.javarush.drogunov.wildisland.enity.game_unit.animals;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;
import ru.javarush.drogunov.wildisland.enity.game_unit.Limits;
import ru.javarush.drogunov.wildisland.interfaces.Eating;
import ru.javarush.drogunov.wildisland.interfaces.Walkable;
import ru.javarush.drogunov.wildisland.util.Randomizer;
import ru.javarush.drogunov.wildisland.util.Statistics;


public abstract class Animal
        extends GameUnit
        implements Walkable, Eating {

    private static final double APPROVE_ERROR = 0.05;

    public Animal(String name, String icon, Limits limits) {
        super(name, icon, limits);
        super.satiety = Randomizer.getRandom(limits.getMaxSatiety());
    }

    @Override
    public boolean eat(GameUnit target) {
        //TODO А есть ли тут необходимость в BigDecimal???
        // Комментарии оставлены специально
//        BigDecimal weightTargetUnit = new BigDecimal(target.getWeight());
//        BigDecimal neededSatiety = new BigDecimal(this.satiety - limits.getMaxSatiety());
//        BigDecimal result = weightTargetUnit.subtract(neededSatiety);
        //TODO и внутри класса лучше как обратятся\записывать через Getter\Setter??
        // Это поля этого класса но родителя
        double maxSatiety = this.limits.getMaxSatiety();
        double neededSatiety = this.satiety - maxSatiety;
        double weightTarget = target.getWeight();
        double result = neededSatiety + weightTarget;
        //TODO вот погрешность можно было бы обработать тут или обработать в сеттере
        plusSatiety(result > 0 ? neededSatiety : weightTarget);
//        System.out.printf("ID atac %d Target %d max %.3f | current = %.3f | need %.3f | weintTar %.3f | resul1 %.3f | gate %.3f |\n",getId(), target.getId(), maxSatiety,this.getSatiety() , neededSatiety, weightTarget, result, gatedSatiety);

        return satiety >= maxSatiety;

    }

    private void plusSatiety(double plus) {
        double error = satiety * APPROVE_ERROR;
        double result = satiety + plus;
        double maxSatiety = limits.getMaxSatiety();

//        System.out.printf("%s Error %.3f, result %.3f = sati %.3f + plus %.3f   SATY = %b\n",getName() , APPROVE_ERROR, result, satiety, plus, isFullSatiety());

        satiety = (result - maxSatiety <= error) ? maxSatiety : result;
//        System.out.printf("Установленная сытность %.3f, Добавлено: %.3f Результат: Сыт? %b\n", satiety, plus, isFullSatiety());
    }

    public boolean isFullSatiety() {
        return this.satiety >= limits.getMaxSatiety();
    }

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
            //Statistics
            Statistics.incrementCountDeadOfHanger();
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
