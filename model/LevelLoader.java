package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вова on 26.03.2016.
 */
public class LevelLoader
{
    private Path levels;
    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }
    public GameObjects getLevel(int level)
    {
        int levl = level % 60;
        if (levl == 0) {
            levl = 60;
        }
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;
        int countY = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            String line;
            int lvl = 0;
            boolean flag = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    lvl = Integer.parseInt(line.split(" ")[1]);
                }
                if (lvl == levl) {
                    if (flag) {
                        int countX = 0;
                        for (char loop : line.toCharArray()) {
                            switch (loop) {
                                case 'X':
                                    walls.add(new Wall((Model.FIELD_SELL_SIZE / 2) + (countX * Model.FIELD_SELL_SIZE), (Model.FIELD_SELL_SIZE / 2) + (countY * Model.FIELD_SELL_SIZE)));
                                    countX++;
                                    break;
                                case '*':
                                    boxes.add(new Box((Model.FIELD_SELL_SIZE / 2) + (countX * Model.FIELD_SELL_SIZE),
                                            (Model.FIELD_SELL_SIZE / 2) + (countY * Model.FIELD_SELL_SIZE)));
                                    countX++;
                                    break;
                                case '.':
                                    homes.add(new Home((Model.FIELD_SELL_SIZE / 2) + (countX * Model.FIELD_SELL_SIZE),
                                            (Model.FIELD_SELL_SIZE / 2) + (countY * Model.FIELD_SELL_SIZE)));
                                    countX++;
                                    break;
                                case '@':
                                    player = new Player((Model.FIELD_SELL_SIZE / 2) + (countX * Model.FIELD_SELL_SIZE), (Model.FIELD_SELL_SIZE / 2) + (countY * Model.FIELD_SELL_SIZE));
                                    countX++;
                                    break;
                                case '&':boxes.add(new Box((Model.FIELD_SELL_SIZE / 2) + (countX * Model.FIELD_SELL_SIZE),
                                        (Model.FIELD_SELL_SIZE / 2) + (countY * Model.FIELD_SELL_SIZE)));
                                    homes.add(new Home((Model.FIELD_SELL_SIZE / 2) + (countX * Model.FIELD_SELL_SIZE),
                                            (Model.FIELD_SELL_SIZE / 2) + (countY * Model.FIELD_SELL_SIZE)));
                                    countX++;
                                    break;
                                default:
                                    countX++;
                                    break;
                            }
                        }
                        countY++;
                    }
                    if (line.length() == 0) {
                        flag = !flag;
                        countY = 0;
                    }
                }
            }
        } catch (IOException e) {
        /*NOP*/
        }
        return new GameObjects(walls, boxes, homes, player);
    }


}
