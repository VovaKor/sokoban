package view;

import controller.EventListener;
import model.Direction;
import model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Вова on 25.03.2016.
 */
public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public Field(View view)
    {
        this.view=view;
        Field.KeyHandler keyHandler = new Field.KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }
    public void paint(Graphics g){

        g.setColor(Color.black);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

        for (GameObject object : view.getGameObjects().getAll()){
            object.draw(g);

        }

    }
    public class KeyHandler extends KeyAdapter
    {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R:
                    eventListener.restart();
                    break;
            }
        }
    }
}
