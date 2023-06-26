package com.svngdo.dummybird.graphics;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Welcome extends GameObject {
    public static final int WIDTH = 288;
    public static final int HEIGHT = 418;
    private final BufferedImage image;

    public Welcome() {
        super((Game.WIDTH - WIDTH) / 2, 100, WIDTH, HEIGHT);
        this.image = ImageUtils.loadImage(Game.IMAGE_PATH + "welcome.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if (!Game.start) {
            g.drawImage(image, x, y, null);
        }
    }
}
