package main.components.unpatterned;

import main.frames.TConsoleEditorWindow;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class TConsoleEditorPane extends JTextPane {
    boolean zoommode =false;
    int default_font_Size = 24;
    public TConsoleEditorPane(){
        this.setContentType("text/html");
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_Z&&zoommode){
                    zoom_in();
                    refresh();
                }
                if (e.getKeyCode()==KeyEvent.VK_O&&zoommode){
                    zoom_out();
                    refresh();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
               if (e.getKeyCode()==KeyEvent.VK_F2){
                   check("exit");
               }
               if (e.getKeyCode()==KeyEvent.VK_F3){
                   zoommode = !zoommode;
                   System.out.println(zoommode);
               }
               if (e.getKeyCode()==KeyEvent.VK_F9&&zoommode){
                   zoom_in();
                   refresh();
               }
               if (e.getKeyCode()==KeyEvent.VK_F10&&zoommode){
                   zoom_out();
                   refresh();
               }
            }
        });
        String html;
        /*
        html = "<html>" +
                "<h1 color ='red'> Hello World </h1>" +
                "</html>";
        this.setText(html);
         */
    }
    public void check(String s){
        String bo="test";
        try {
             bo = this.getText(this.getText().indexOf(s.charAt(0)),this.getText().indexOf(s.charAt(s.length())));
            if(bo.equals(s)){
                System.out.println(bo);
            };
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
        catch (IndexOutOfBoundsException es){
            System.out.println(bo+s);
        }
    }
    public void append(String s){
        this.setText(this.getText()+"\n"+s);
    }
    public void zoom_in(){
        default_font_Size++;
    }
    public void zoom_out(){
        default_font_Size--;
    }
    public void refresh(){
        this.setFont(new Font("asdasd",Font.BOLD,default_font_Size));
    }
}
