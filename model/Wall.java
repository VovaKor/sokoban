package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Вова on 26.03.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }
    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.getHSBColor( 26.09f, 68.05f, 66.27f));
        int leftTopCorner= getX() - getWidth() / 2;
        int leftBottomCorner = getY() - getHeight() / 2;

        graphics.drawRect(leftTopCorner, leftBottomCorner, getWidth(), getHeight());
        graphics.fillRect(leftTopCorner, leftBottomCorner, getWidth(), getHeight());

    }
}
