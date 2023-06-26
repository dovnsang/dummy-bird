package com.svngdo.dummybird.input;

import com.svngdo.dummybird.ui.Game;
import com.svngdo.dummybird.utils.ObjectUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputManager implements MouseListener, KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!Game.start) {
                Game.start = true;
            }
            goUp();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle get ready screen click
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!Game.start
                    && ObjectUtils.checkCollision(e.getX(), e.getY(), 0, 0, Game.WIDTH, Game.HEIGHT)) {
                Game.start = true;
            }
            goUp();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void goUp() {
        if (!Game.over) {
            Game.bird.setVelY(-10);
        }
    }
}
