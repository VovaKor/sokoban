package controller;

import model.Direction;

/**
 * Created by Вова on 26.03.2016.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}
