package main.patterns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;

public abstract class TConsoleJFramePattern extends JFrame {
    KeyListener listener ;

    public static boolean shouldUpdate = false;



    protected final JFrame instance_frame ;
    public TConsoleJFramePattern(String TITLE){
        instance_frame = this;
        instance_frame.setTitle(TITLE);
        create();
        settings();
        add();
        go();
    }
    public void create(){

    }
    public void for_run(){

    }
    public void run(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            for_run();

            }
        });
        thread.start();
    }
    public void loop(){


    }

    public void setListener(KeyListener listener) {
        this.listener = listener;
    }

    public void settings(){
        this.setFocusable(true);
        settings_listeners_key();
    }
    public void go(){
        this.setVisible(true);
    }

    public void back(){
        this.setVisible(false);
    }
    public void add(){

    }
   public void settings_listeners_key(){

   }
    public void addKLForEveryThin(){
    }
    public JScrollPane addScrollPane(Component component){
        JScrollPane pane = new JScrollPane(component);
        this.add(pane);
        return pane;
    }
   public static int i=0;
    public  void refresh(){
        i++;
        if (i<2){
            back();
            create();
            settings();
            add();
            go();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void logEveryThing(){

    }
    public JFrame getInstance_frame() {
        return instance_frame;
    }



}
