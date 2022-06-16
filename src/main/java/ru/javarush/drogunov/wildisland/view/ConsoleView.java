package ru.javarush.drogunov.wildisland.view;

import ru.javarush.drogunov.wildisland.enity.animals.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Я переделаю)
public class ConsoleView implements View {
    private final GameSpace gameSpace;
    private final int positions = 3;
    private final String border = "═".repeat(positions);

    public ConsoleView(GameSpace gameSpace) {
        this.gameSpace = gameSpace;
    }


    @Override
    public String showStatistics() {
        Cell[][] cells = gameSpace.getSpace();
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<Type, Set<GameUnit>> residents = cell.getMapGameUnits();
                for (Set<GameUnit> s : residents.values()) {
                    if (s.size() > 0) {
                        String gameUnitName = s.stream().findAny().get().toString();
                        if (map.containsKey(gameUnitName)) {
                            Integer oldCount = map.get(gameUnitName);
                            map.put(gameUnitName, s.size() + oldCount);
                        } else {
                            map.put(s.stream().findAny().get().toString(), s.size());
                        }
                    }
                }
//                System.out.print(map.size() + " k v "+  residents.values().size() + " ");
            }
        }
        System.out.println(map);
        return map.toString();
    }

    @Override
    public String showMap() {
        Cell[][] cells = gameSpace.getSpace();
        final int rows = cells.length;
        final int cols = cells[0].length;
        int oneCellWidth = positions + 1;
        int width = oneCellWidth * cols + 2;
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
        return cell.getMapGameUnits().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .limit(positions)
                .map(list -> list.stream().findAny().get().getClass().getSimpleName().substring(0, 1))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private String line(int cols, char left, char center, char right) {
        return (IntStream.range(0, cols)
                .mapToObj(col -> (col == 0 ? left : center) + border)
                .collect(Collectors.joining("", "", String.valueOf(right))));
    }
}
