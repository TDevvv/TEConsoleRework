package main.frames;

import main.components.TConsoleEditorWindowPanel;
import main.components.unpatterned.TConsoleEditorPane;
import main.patterns.TConsoleJFramePattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class TConsoleEditorWindow extends TConsoleJFramePattern {

    public static TConsoleEditorWindow window;
    public static TConsoleEditorPane pane;
    public static TConsoleEditorWindowPanel panel;
    public static final String VERSION  ="INDEV/V.1";
    public TConsoleEditorWindow(String TITLE) {
        super(TITLE);
    }

    @Override
    public void settings() {
        this.setSize(1920,1080);
        this.setPreferredSize(this.getSize());
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.pack();
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.settings();
    }

    @Override
    public void for_run() {
       window = new TConsoleEditorWindow("TEST/> "+new Date()+" VERSION/>"+VERSION);
        super.for_run();
    }

    @Override
    public void settings_listeners_key() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
              if (e.getKeyCode()==KeyEvent.VK_ENTER){
              }
            }
        });

        super.settings_listeners_key();
    }

    @Override
    public void create() {
        TConsoleEditorWindowPanel editorPanel = new TConsoleEditorWindowPanel();
        panel = editorPanel;
        super.create();
    }

    @Override
    public void add() {
        TConsoleEditorPane editorPane =new TConsoleEditorPane();
        pane = editorPane;
        panel.setSize(this.getSize());
        this.add(panel);
        this.add(editorPane);
        super.add();
    }

    @Override
    public void go() {
        super.go();
    }

    public static void main(String[] args) {
       TConsoleEditorWindow window1 = new TConsoleEditorWindow("test");
    }

}
