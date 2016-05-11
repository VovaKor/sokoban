package view;

import controller.Controller;
import controller.EventListener;
import model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public void update(){
        field.repaint();
    }
    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }
    public void completed(int level){
        this.update();
        JOptionPane.showMessageDialog(null,"вы прошли уровень "+ level);
        controller.startNextLevel();
    }
    public void setEventListener(EventListener eventListener)
    {
        field.setEventListener(eventListener);
    }

    public View(Controller controller) {
        this.controller = controller;
    }


    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }


}
