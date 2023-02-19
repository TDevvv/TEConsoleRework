package main.components.pattern;

import main.logging.TLogger;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.IOException;

public abstract class TCComponentPatternTextArea extends JTextArea {
     protected static boolean go_for_edit ;
     protected final static JTextArea instance_textarea = new JTextArea();
     public TCComponentPatternTextArea(){
          settings();
     }
     public void settings(){
          if (go_for_edit){
               settings_private(true);
          }else{
               settings_private(false);
          }
          setFontThings();
     this.setFocusable(true);
     settings_listener_key();
     };
     public void defaultVisible(){

     };
     public void settings_listener_key(){

     }
     public void settings_private(boolean go){
          go_for_edit = go;
     }

     public  static JTextArea getInstance_textarea() {
          return instance_textarea;
     }
     public Font registerFont(String font_name_path){
          Font font = null;
          try {
               font = Font.createFont(Font.TRUETYPE_FONT,getClass().getClassLoader().getResourceAsStream(font_name_path));
               font.deriveFont(24f);
               return font;
          } catch (FontFormatException | IOException e) {
               throw new RuntimeException(e);
          }
     }
     public void logEveryThing(){
     }
     public void setFontThings(){

     }
}
