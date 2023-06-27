package com.svngdo.dummybird.entities;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;
import com.svngdo.dummybird.utils.ObjectManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird extends GameObject {
    public static final int WIDTH = 51;
    public static final int HEIGHT = 36;

    private BufferedImage[] images;
    private float velY;
    public float maxSpeed;
    private int currentImage;
    private int flapDelay;
    private long lastAnimationTime;

    public Bird() {
        super((Game.WIDTH - WIDTH) / 2, (Game.HEIGHT - HEIGHT) / 2 - 1, WIDTH, HEIGHT);
        images = new BufferedImage[3];
        for (int i = 0; i < 3; i++) {
            images[i] = ImageUtils.loadImage(Game.IMAGE_PATH + "bird-" + (i + 1) + ".png");
        }
        init();
    }

    public void init() {
        x = (Game.WIDTH - WIDTH) / 2;
        y = (Game.HEIGHT - HEIGHT) / 2 - 1;
        flapDelay = 300;
        lastAnimationTime = 0;
        velY = 0;
        maxSpeed = 10f;
        currentImage = 0;
    }

    public void flap() {
        long elapsedTime = (System.nanoTime() - lastAnimationTime) / 1_000_000; // convert nanosecond to millisecond
        if (elapsedTime > flapDelay) {
            ++currentImage;
            lastAnimationTime = System.nanoTime();
        }
        if (currentImage >= images.length) {
            currentImage = 0;
        }
    }

    public void flyUp() {
        if (!Game.over) {
            velY = -10;
        }
    }

    @Override
    public void update() {
        int groundY = Game.HEIGHT - Ground.HEIGHT;

        // Flap animation
        if (!Game.over) {
            flap();
        }

        // Make the bird falling
        if (Game.start) {
            velY += Game.GRAVITY;
            y += velY;
        }

        // Balance the flap when falling
        if (flapDelay < 300) {
            flapDelay += 3;
        }

        // Sky limit
        if (y < 0) {
            velY = 0;
            y = 0;
        }

        // Ground limit
        if (y + height > groundY) {
            velY = 0;
            y = groundY - height;
        }

        // Check collision
        for (GameObject o : ObjectManager.pipes) {
            if (o instanceof Pipe) {
                if (o.getBounds().intersects(this.getBounds())) {
                    Game.over = true;
                }
            }
        }

    }

    @Override
    public void render(Graphics g) {
        if (Game.start) {
            g.drawImage(images[currentImage], x, y, null);
        }
    }

    public void setFlapDelay(int flapDelay) {
        this.flapDelay = flapDelay;
    }

}
