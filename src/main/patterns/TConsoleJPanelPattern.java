package main.patterns;

import main.patterns.interfaces.IWindow;

import javax.swing.*;
import java.util.Date;

public abstract class TConsoleJPanelPattern extends JPanel implements IWindow  {
    JPanel instance;
    public TConsoleJPanelPattern(){
        settings();
        key_listener_settings();
        additional();
        add();
    }

    @Override
    public void run() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
              for_run();
            }
        });
        thread.run();
    }

    @Override
    public JPanel get_setInstance(JPanel panel) {
        instance = panel;
        return panel;
    }

    @Override
    public void for_run() {
        System.out.println("Class Test::/> "+new Date()+" Class::/> "+TConsoleJPanelPattern.class);
    }
}
