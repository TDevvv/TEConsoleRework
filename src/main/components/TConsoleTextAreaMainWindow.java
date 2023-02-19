package main.components;
import main.components.pattern.TCComponentPatternTextArea;
import main.listeners.key.TCKeyListener;
import main.outstream.TCOutputStream;
import main.outstream.TCPrintStream;
import main.util.ready.TConsoleReady;

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;

public class TConsoleTextAreaMainWindow extends TCComponentPatternTextArea {
    public static TCPrintStream printStream;
    public TConsoleTextAreaMainWindow(){
        super();
       // PrintStream printStream = new PrintStream(new TCOutputStream(this));
        printStream = new TCPrintStream(new TCOutputStream(this));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    @Override
    public void settings() {
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setEditable(false);
        this.setSelectedTextColor(Color.WHITE);
        this.setSize(TConsoleReady.getDefaultConsoleWidth(),TConsoleReady.getDefaultConsoleHeight());
        super.settings();
    }
    @Override
    public void setFontThings(){
        this.setFont(registerFont("lucon.ttf").deriveFont(24f));
    }

    @Override
    public void settings_listener_key() {
        this.addKeyListener(new TCKeyListener());
    }

    @Override
    public void logEveryThing() {
        super.logEveryThing();
    }

    public void welcome_message(){

    }


}
