package com.svngdo.dummybird.entities;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ground extends GameObject {
    public static final int WIDTH = 432;
    public static final int HEIGHT = 144;

    private BufferedImage image;
    private int x1, x2;
    private float velX;

    public Ground() {
        super(0, Game.HEIGHT - HEIGHT, WIDTH, HEIGHT);
        image = ImageUtils.loadImage(Game.IMAGE_PATH + "ground.png");
        init();
    }

    public void init() {
        velX = 3;
        x1 = 0;
        x2 = Game.WIDTH;
    }

    @Override
    public void update() {
        if (Game.start && !Game.over) {
            x1 -= velX;
            x2 -= velX;

            if (x1 + WIDTH <= 0) {
                x1 = Game.WIDTH;
            }
            if (x2 + WIDTH <= 0) {
                x2 = Game.WIDTH;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x1, y, null);
        g.drawImage(image, x2, y, null);
    }
}
