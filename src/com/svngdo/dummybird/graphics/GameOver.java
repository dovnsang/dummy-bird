package com.svngdo.dummybird.graphics;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameOver extends GameObject {
    public static final int WIDTH = 288;
    public static final int HEIGHT = 63;

    private final BufferedImage image;

    public GameOver() {
        super((Game.WIDTH - WIDTH) / 2, Game.HEIGHT / 4, WIDTH, HEIGHT);
        image = ImageUtils.loadImage(Game.IMAGE_PATH + "gameover.png");
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        if (Game.over) {
            g.drawImage(image, x, y, null);
        }
    }
}
