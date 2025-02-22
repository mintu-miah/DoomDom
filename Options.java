//package com.game.src.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Options {

    public Rectangle backButton = new Rectangle(22, 535, 67, 42);

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(backButton);
    }

}