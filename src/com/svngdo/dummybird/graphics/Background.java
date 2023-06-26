package com.svngdo.dummybird.graphics;

import com.svngdo.dummybird.base.GameObject;
import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {
    private final BufferedImage image;

    public Background() {
        super(0, 0, Game.WIDTH, Game.HEIGHT);
        this.image = ImageUtils.loadImage(Game.IMAGE_PATH + "background.png");
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        if (Game.running) {
            g.drawImage(image, x, y, null);
        }
    }
}
