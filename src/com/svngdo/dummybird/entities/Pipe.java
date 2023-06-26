package com.svngdo.dummybird.entities;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.enums.PipeType;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;
import com.svngdo.dummybird.utils.ObjectManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pipe extends GameObject {
    public static final int WIDTH = 78;
    public static final int HEIGHT = 480;

    private BufferedImage image;
    private float velX;
    private PipeType type;

    public Pipe(int x, int y, PipeType type) {
        super(x, y, WIDTH, HEIGHT);
        this.type = type;
        if (type == PipeType.TOP) {
            image = ImageUtils.loadImage(Game.IMAGE_PATH + "pipe-top.png");
        } else {
            image = ImageUtils.loadImage(Game.IMAGE_PATH + "pipe-bottom.png");
        }
        init();
    }

    public void init() {
        velX = 3;
    }

    @Override
    public void update() {
        if (!Game.over) {
            x -= velX;
        }

        if (x + WIDTH < 0) {
            ObjectManager.characters.remove(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
