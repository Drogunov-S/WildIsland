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

public class ConsoleView implements View {
    private final GameMap gameMap;
    private final int positions = 3;
    private final String border = "═".repeat(positions);

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }

/*    @Override
    public String showStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        Cell[][] cells = gameMap.getSpace();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                var residents = cell.getUnitsMap();
                if (Objects.nonNull(residents)) {
                    residents.values().stream()
                            .filter(set -> set.size() > 0)
                            .forEach(set -> {
                                        String icon = set.stream().findAny().get().getIcon();
                                        statistics.put(icon, statistics.getOrDefault(icon, 0) + set.size());
                                    }
                            );
                }
            }
        }
        System.out.println(statistics + "\n");
        return statistics.toString();
    }*/
    @Override
    public String showStatistics() {
        System.out.println("Всего на карте: " + gameMap.getSetUnits().size());
        Cell[][] cells = gameMap.getSpace();
        //TODO не могу как передать компаратор для сортировки по значению
        Map<String, Integer> statisticsMap = new TreeMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                //TODO еще раз понять что такое Type
                Map<String, Set<GameUnit>> residents = cell.getUnitsMap();
                for (Set<GameUnit> unitsOnCell : residents.values()) {
                    if (unitsOnCell.size() > 0) {
                        String gameUnitName = unitsOnCell.stream().findAny().get().toString();
                        if (statisticsMap.containsKey(gameUnitName)) {
                            Integer oldCount = statisticsMap.get(gameUnitName);
                            statisticsMap.put(gameUnitName, unitsOnCell.size() + oldCount);
                        } else {
                            statisticsMap.put(unitsOnCell.stream().findAny().get().toString(), unitsOnCell.size());
                        }
                    }
                }
            }
        }
        StringBuilder resultString = new StringBuilder();
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
        System.out.println(resultString);
        return resultString.toString();
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

                cell.getUnitsMap().values().forEach(set -> {
                    set.forEach(unit -> countUnits.getAndIncrement());
                });
                String str = "[" + j + " " + i + "] = " + countUnits;
                stringBuilder.append(str + "\t") ;
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
