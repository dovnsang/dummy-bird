package com.svngdo.dummybird.graphics;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RestartButton extends GameObject {
    public static final int WIDTH = 200;
    public static final int HEIGHT = 125;

    public final BufferedImage IMAGE;

    public RestartButton() {
        super((Game.WIDTH - WIDTH) / 2, (Game.HEIGHT - HEIGHT) / 2, WIDTH, HEIGHT);
        IMAGE = ImageUtils.loadImage(Game.IMAGE_PATH + "restart.png");
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        if (Game.over) {
            g.drawImage(IMAGE, x, y, null);
        }
    }
}
