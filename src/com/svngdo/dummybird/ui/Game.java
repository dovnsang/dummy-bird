package com.svngdo.dummybird.ui;

import com.svngdo.dummybird.entities.Bird;
import com.svngdo.dummybird.entities.Ground;
import com.svngdo.dummybird.graphics.Background;
import com.svngdo.dummybird.graphics.GameOver;
import com.svngdo.dummybird.graphics.RestartButton;
import com.svngdo.dummybird.graphics.Welcome;
import com.svngdo.dummybird.input.GameInput;
import com.svngdo.dummybird.utils.ObjectManager;
import com.svngdo.dummybird.utils.PipeManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 432;
    public static final int HEIGHT = 768;
    public static final float GRAVITY = 0.53f;
    public static final String IMAGE_PATH = "src/resources/sprites/";

    public static boolean running;
    public static boolean start;
    public static boolean over;
    public static Bird bird;
    public static RestartButton restartButton;

    private Thread thread;
    private BufferStrategy bufferStrategy;

    public Game(int width, int height) {
        setSize(new Dimension(width, height));
    }

    public void init() {
        // Do not init this BufferStrategy in constructor
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();

        GameInput gameInput = new GameInput();
        addKeyListener(gameInput);
        addMouseListener(gameInput);

        Background background = new Background();
        Welcome welcome = new Welcome();
        GameOver gameOver = new GameOver();
        Ground ground = new Ground();
        restartButton = new RestartButton();
        bird = new Bird();

        ObjectManager.background.add(background);
        ObjectManager.characters.add(bird);
        ObjectManager.characters.add(ground);
        ObjectManager.foreground.add(welcome);
        ObjectManager.foreground.add(gameOver);
        ObjectManager.foreground.add(restartButton);

        requestFocus();
    }

    // synchronized to ensure running variable atomically
    public synchronized void start() {
        if (running) return;
        running = true;

        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void restart() {
        ObjectManager.clearPipes();
        PipeManager.init();
        bird.init();
        
        start = false;
        over = false;
    }

    public void update() {
        ObjectManager.update();
        PipeManager.spawnPipes();
    }

    public void render() {
        Graphics g = bufferStrategy.getDrawGraphics();
        ObjectManager.render(g);
        bufferStrategy.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        // Initialize game loop;
        long lastTime = System.nanoTime();
        double FPS = 60;
        double nanosecondPerUpdate = 1_000_000_000 / FPS;
        double delta = 0;

        // FPS counter
        long fpsTimer = System.currentTimeMillis();
        int fps = 0;

        while (running) {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime - lastTime;
            delta += elapsedTime / nanosecondPerUpdate;
            lastTime = currentTime;

            while (delta > 0) {
                --delta;

                ++fps;
                // Update game state
                update();
                // Render new state
                render();
            }

            // Display FPS
            if (System.currentTimeMillis() - fpsTimer > 1000) {
                System.out.println("FPS = " + fps);
                fpsTimer += 1000;
                fps = 0;
            }
        }
        stop();
    }

}