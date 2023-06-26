package com.svngdo.dummybird.utils;

public class ObjectUtils {

    public static boolean checkCollision(int mouseX, int mouseY, int x, int y, int width, int height) {
        return mouseX >= x
                && mouseX <= x + width
                && mouseY >= y
                && mouseY <= y + height;
    }

}
