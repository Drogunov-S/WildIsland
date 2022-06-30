package ru.javarush.drogunov.wildisland.view;

import ru.javarush.drogunov.wildisland.enity.game_space.Cell;
import ru.javarush.drogunov.wildisland.enity.game_space.GameMap;
import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class ConsoleView implements View {
    private final GameMap gameMap;
    private final int positions = 3;
    private final String border = "═".repeat(positions);

    private int countMinusSatiety = 0;

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    @SuppressWarnings("I don't undestande what to do it this warrning")
    public String showStatistics() {
        Cell[][] cells = gameMap.getSpace();
        //TODO не могу как передать компаратор для сортировки по значению
        Map<String, Integer> statisticsMap = new TreeMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                //TODO еще раз понять что такое Type
                Map<String, Set<GameUnit>> residents = cell.getUnitsMap();
                for (Set<GameUnit> unitsOnCell : residents.values()) {
                    count(unitsOnCell);
                    if (unitsOnCell.size() > 0) {
                        String gameUnitName = unitsOnCell
                                .stream()
                                .findAny()
                                .get()
                                .toString();
                        if (statisticsMap.containsKey(gameUnitName)) {
                            Integer oldCount = statisticsMap.get(gameUnitName);
                            statisticsMap.put(gameUnitName, unitsOnCell.size() + oldCount);
                        } else {
                            statisticsMap.put(unitsOnCell.stream()
                                    .findAny()
                                    .get()
                                    .toString(), unitsOnCell.size());
                        }
                    }
                }
            }
        }
        String all = "Всего на карте: " + gameMap.getSetUnits().size() + '\n';
        StringBuilder resultString = new StringBuilder();
        resultString.append(all);
        int count = 0;

        for (Map.Entry<String, Integer> units : statisticsMap.entrySet()) {
            int columns = 16;
            if (count == columns) {
                resultString.append('\n');
                count = 0;
            }
            resultString.append(units.getKey()).append(" = ").append(units.getValue()).append(" ");
            count++;
        }
        System.out.println("Сытность в минусе: " + countMinusSatiety);
        countMinusSatiety = 0;
        System.out.println(resultString);
        return resultString.toString();
    }

    private void count(Set<GameUnit> unitsOnCell) {
    unitsOnCell.forEach(gameUnit -> {
        if (gameUnit.getSatiety() < 0) {
            countMinusSatiety++;
        }
    });
    }

    @Override
    //TODO разобрать и понять
    public String showMap() {
        Cell[][] cells = gameMap.getSpace();
        final int rows = cells.length;
        final int cols = cells[0].length;
        StringBuilder out = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            out.append(row == 0
                    ? line(cols, '╔', '╦', '╗')
                    : line(cols, '╠', '╬', '╣')
            ).append("\n");
            for (int col = 0; col < cols; col++) {
                String residentSting = get(cells[row][col]);
                out.append(String.format("║%-" + positions + "s", residentSting));
            }
            out.append('║').append("\n");
        }
        out.append(line(cols, '╚', '╩', '╝')).append("\n");
        System.out.println(out);
        return out.toString();
    }

    private String get(Cell cell) {
        return cell.getUnitsMap().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .limit(positions)
                .map(list -> list.stream().findAny().get().toString().substring(0, 1))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private String line(int cols, char left, char center, char right) {
        return (IntStream.range(0, cols)
                .mapToObj(col -> (col == 0 ? left : center) + border)
                .collect(Collectors.joining("", "", String.valueOf(right))));
    }

    @Override
    public String showCountCellUnits() {
        StringBuilder stringBuilder = new StringBuilder();
        Cell[][] space = gameMap.getSpace();
        for (int j = 0, spaceLength = space.length; j < spaceLength; j++) {
            Cell[] cells = space[j];
            for (int i = 0; i < cells.length; i++) {
                Cell cell = cells[i];
                AtomicInteger countUnits = new AtomicInteger();

                cell.getUnitsMap().values().forEach(set -> set
                        .forEach(unit -> countUnits.getAndIncrement()));
                String str = "[" + j + " " + i + "] = " + countUnits;
                stringBuilder.append(str).append("\t");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
