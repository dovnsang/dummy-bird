package com.svngdo.dummybird.utils;

import com.svngdo.dummybird.entities.Pipe;
import com.svngdo.dummybird.enums.PipeType;
import com.svngdo.dummybird.ui.Game;

import java.util.Random;

public class PipeManager {
    private static final int DELAY = 2000; // millisecond
    private static long lastSpawnTime = 0;

    public static void init() {
        lastSpawnTime = 0;
    }

    public static void spawn() {
        Random random = new Random();
        int spacing = 180;
        int minHeight = 90;
        int maxHeight = 360;
        int randomHeight = random.nextInt((maxHeight - minHeight) + 1) + minHeight;
        int topY = randomHeight - Pipe.HEIGHT;

        Pipe topPipe = new Pipe(600, topY, PipeType.TOP);
        Pipe bottomPipe = new Pipe(600, randomHeight + spacing, PipeType.BOTTOM);

        ObjectManager.pipes.add(topPipe);
        ObjectManager.pipes.add(bottomPipe);
    }

    public static void spawnPipes() {
        if (Game.start && !Game.over) {
            long now = System.currentTimeMillis();
            if (now - lastSpawnTime > DELAY) {
                spawn();
                lastSpawnTime = now;
            }
        }
    }
}
