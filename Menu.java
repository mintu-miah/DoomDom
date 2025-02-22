//package com.game.src.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {

    public Rectangle playButton = new Rectangle(355, 320, 121, 39);
    public Rectangle optionsButton = new Rectangle(345, 372, 145, 39);
    public Rectangle exitButton = new Rectangle(355, 420, 121, 39);

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(playButton);
        g2d.draw(optionsButton);
        g2d.draw(exitButton);

    }
}
