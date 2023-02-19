package main.listeners.key;

import main.TConsoleMainWindow;
import main.components.component_bridge.TConsoleComponentBridge;
import main.frames.TConsoleInputWindow;
import main.patterns.TConsoleJFramePattern;
import run.TConsoleRunner;

import java.awt.event.KeyEvent;

public class TCKeyEvents {
    public static TConsoleInputWindow window = new TConsoleInputWindow("");
    public static int j=0;
    public static void events(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        else if (e.getKeyCode()==KeyEvent.VK_F5) {
            TConsoleJFramePattern.i = 0;
            TConsoleMainWindow.shouldUpdate = true;
            TConsoleRunner.console.refresh();
        } else if (e.getKeyCode()==KeyEvent.VK_F1) {
            window.setVisible(!window.isVisible());
        } else if (e.getKeyCode()==KeyEvent.VK_ENTER) {

        }
    }
}
