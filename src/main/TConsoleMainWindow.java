package main;

import main.components.TConsoleTextAreaMainWindow;
import main.listeners.key.TCKeyListener;
import main.outstream.TCOutputStream;
import main.patterns.TConsoleJFramePattern;
import main.util.ready.TConsoleReady;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.plaf.metal.MetalScrollPaneUI;

public class TConsoleMainWindow extends TConsoleJFramePattern {
    public static TConsoleTextAreaMainWindow tConsoleTextArea;

    public static TConsoleTextAreaMainWindow gettConsoleTextArea() {
        return tConsoleTextArea;
    }

    TCOutputStream output_Stream_new;
    public TConsoleMainWindow(String TITLE) {
        super(TITLE);
        go();
    }

    @Override
    public void settings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setSize(TConsoleReady.getDefaultConsoleWidth(),TConsoleReady.getDefaultConsoleHeight());
        this.setResizable(true);
        this.setPreferredSize(new Dimension(TConsoleReady.getDefaultConsoleWidth(),TConsoleReady.getDefaultConsoleHeight()));
        this.pack();
        this.setForeground(Color.WHITE);
        super.settings();
    }


    @Override
    public void create() {
        tConsoleTextArea = new TConsoleTextAreaMainWindow();
        super.create();
    }

    @Override
    public void add() {
        MetalScrollPaneUI metalScrollPaneUI = new MetalScrollPaneUI();
        this.add(tConsoleTextArea);
        this.addScrollPane(tConsoleTextArea);
        super.add();
    }

    @Override
    public void settings_listeners_key() {
        this.addKeyListener(new TCKeyListener());
        super.settings_listeners_key();
    }

    @Override
    public void refresh() {
        super.refresh();
    }

    @Override
    public void setListener(KeyListener listener) {
        super.setListener(new TCKeyListener());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add( new JLabel(" Outout" ), BorderLayout.NORTH );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextArea ta = new JTextArea();
        ta.setBackground(Color.BLACK);
        ta.setForeground(Color.WHITE);
        ta.setFocusable(true);
        ta.setCaretColor(Color.WHITE);
        ta.setFont(new Font("Arial",Font.BOLD,24));

        /* a remainder of output_stream things.
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, 60 );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );

         */



        frame.add( new JScrollPane( ta )  );

        frame.pack();
        frame.setVisible( true );
        frame.setSize(800,600);

        throw new RuntimeException();

    }

}