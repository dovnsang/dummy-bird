package com.svngdo.dummybird.graphics;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Score extends GameObject {
    public static final int WIDTH = 32;
    public static final int HEIGHT = 48;
    private int value;
    private BufferedImage[] images;
    private BufferedImage[] renderImages;

    public Score() {
        super((Game.WIDTH - WIDTH) / 2, Game.HEIGHT / 24, WIDTH, HEIGHT);
        images = new BufferedImage[10];
        for (int i = 0; i < 10; i++) {
            images[i] = ImageUtils.loadImage(Game.IMAGE_PATH + i + ".png");
        }
        init();
    }

    public void init() {
        value = 0;
        renderImages = new BufferedImage[3];
    }

    @Override
    public void update() {
        if (value < 10) {
            renderImages[0] = images[value];
        } else if (value <= 99) {
            renderImages[0] = images[value / 10];
            renderImages[1] = images[value % 10];
        } else if (value <= 999) {
            renderImages[0] = images[value / 100];
            renderImages[1] = images[(value % 100) / 10];
            renderImages[2] = images[(value % 100) % 10];
        }
    }

    @Override
    public void render(Graphics g) {
        if (Game.start) {
            if (value < 10) {
                g.drawImage(renderImages[0], x, y, null);
            } else if (value >= 10 && value <= 99) {
                g.drawImage(renderImages[0], x - (WIDTH / 2) - 1, y, null);
                g.drawImage(renderImages[1], (x + WIDTH) - (WIDTH / 2) + 1, y, null);
            } else if (value >= 100 && value <= 999) {
                g.drawImage(renderImages[0], x - WIDTH - 1, y, null);
                g.drawImage(renderImages[1], x, y, null);
                g.drawImage(renderImages[2], x + WIDTH + 1, y, null);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}