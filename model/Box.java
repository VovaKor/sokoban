package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Вова on 26.03.2016.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.ORANGE);
        int leftTopCorner= getX() - getWidth() / 2;
        int leftBottomCorner = getY() - getHeight() / 2;

        graphics.drawRect(leftTopCorner, leftBottomCorner, getWidth(), getHeight());
        graphics.fillRect(leftTopCorner, leftBottomCorner, getWidth(), getHeight());

    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
