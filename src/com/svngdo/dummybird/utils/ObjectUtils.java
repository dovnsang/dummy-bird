package com.svngdo.dummybird.utils;

import com.svngdo.dummybird.base.GameObject;

public class ObjectUtils {

    public static boolean checkCollision(int mouseX, int mouseY, int x, int y, int width, int height) {
        return mouseX >= x
                && mouseX <= x + width
                && mouseY >= y
                && mouseY <= y + height;
    }

    public static boolean checkCollision(int mouseX, int mouseY, GameObject o) {
        return mouseX >= o.getX()
                && mouseX <= o.getX() + o.getWidth()
                && mouseY >= o.getY()
                && mouseY <= o.getY() + o.getHeight();
    }

}
