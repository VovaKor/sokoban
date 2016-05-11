package controller;

import model.Direction;
import model.GameObjects;
import model.Model;
import view.View;

/**
 * Created by Вова on 25.03.2016.
 */
public class Controller implements EventListener
{
    @Override
    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart()
    {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel()
    {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level)
    {
        view.completed(level);
    }

    private View view;
    private Model model;

    public Controller()
    {
        this.view = new View(this);
        this.model = new Model();
        view.init();
        model.restart();
        model.setEventListener(this);
        view.setEventListener(this);

    }
    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }

    public static void main(String[] args)
    {

        Controller controller = new Controller();

    }


}
