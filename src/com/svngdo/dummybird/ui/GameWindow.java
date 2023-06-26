package com.svngdo.dummybird.ui;

import javax.swing.*;

public class GameWindow extends JFrame {

    public final Game game;

    public GameWindow() {
        setTitle("Dummy Bird");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        game = new Game(Game.WIDTH, Game.HEIGHT);
        add(game);
        pack();


        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void start() {
        game.start();
    }

}
