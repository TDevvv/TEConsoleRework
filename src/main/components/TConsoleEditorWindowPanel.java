package main.components;

import main.patterns.TConsoleJPanelPattern;

import javax.swing.*;
import java.awt.*;

public class TConsoleEditorWindowPanel extends TConsoleJPanelPattern {

    public TConsoleEditorWindowPanel(){

    }
    @Override
    public void for_run() {
        super.for_run();
    }

    @Override
    public void settings() {
        //this.setSize(1920,1080);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setFocusable(true);
        this.setVisible(true);
    }

    @Override
    public JPanel get_setInstance(JPanel panel) {
        return super.get_setInstance(this);
    }

    @Override
    public void add() {

    }

    @Override
    public void key_listener_settings() {

    }

    @Override
    public void additional() {

    }

    @Override
    public String returnName(String S) {
        return null;
    }

    @Override
    public Integer returnValue(Integer I) {
        return null;
    }
}
