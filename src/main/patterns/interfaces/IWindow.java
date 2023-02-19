package main.patterns.interfaces;

import javax.swing.*;

public interface IWindow  {
    void settings();
    void run();
    void for_run();
    void add();
    void key_listener_settings();
    void additional();
    JPanel get_setInstance(JPanel panel);

    String returnName(String S);
    Integer returnValue(Integer I);


}
