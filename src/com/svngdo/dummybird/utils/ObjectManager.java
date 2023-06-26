package com.svngdo.dummybird.utils;

import com.svngdo.dummybird.base.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ObjectManager {
    public static List<GameObject> background = new LinkedList<>();
    public static List<GameObject>  characters = new LinkedList<>();
    public static List<GameObject>  pipes = new LinkedList<>();
    public static List<GameObject> foreground = new LinkedList<>();

    public static void update() {
        for (GameObject o : background) {
            o.update();
        }
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).update();
        }
        for (GameObject o : characters) {
            o.update();
        }
        for (GameObject o : foreground) {
            o.update();
        }
    }

    public static void render(Graphics g) {
        for (GameObject o : background) {
            o.render(g);
        }
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).render(g);
        }
        for (GameObject o : characters) {
            o.render(g);
        }
        for (GameObject o : foreground) {
            o.render(g);
        }
    }

}
