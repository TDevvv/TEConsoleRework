package main.listeners.key;

import main.patterns.TConsoleJFramePattern;
import run.TConsoleRunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TCKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       TCKeyEvents.events(e);

    }


    @Override
    public void keyReleased(KeyEvent e) {


    }

}
