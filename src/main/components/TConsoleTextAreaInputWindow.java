package main.components;
import main.TConsoleMainWindow;
import main.command.executer.TConsoleFileSystem;
import main.command.parser.TConsoleCommandParser;
import main.components.component_bridge.TConsoleComponentBridge;
import main.components.pattern.TCComponentPatternTextArea;
import main.listeners.key.TCKeyEvents;
import main.listeners.key.TCKeyListener;
import main.logging.TLogger;
import main.util.ready.TConsoleReady;
import main.util.ready.TConsoleReadyDate;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static main.components.component_bridge.TConsoleComponentBridge.logger;
public class TConsoleTextAreaInputWindow extends TCComponentPatternTextArea {

    public static boolean debugMode = false;

    public TConsoleTextAreaInputWindow(){
        super();

    }

  TConsoleFileSystem system = new TConsoleFileSystem();
    Date date = new Date();
    @Override
    public void settings() {
        this.setEditable(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setSelectedTextColor(Color.WHITE);
        this.setFocusTraversalKeysEnabled(true);
        this.setSize(TConsoleReady.getInputConsoleWidth(),80);
        super.settings();
    }
    @Override
    public void settings_listener_key() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    TConsoleComponentBridge.input_text_area.setText("");
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (debugMode){
                    logger.log("EVENT::/> "+KeyEvent.getKeyText(e.getKeyCode())+" KC::/> "+e.getKeyCode());
                }
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    String command =TConsoleComponentBridge.input_text_area.getText();
                    String trimmed_command = TConsoleComponentBridge.input_text_area.getText().trim();
                    if (!TConsoleFileSystem.readFileForSpecific(trimmed_command,new File("command.dat"))){
                        try{
                            trimmed_command = trimmed_command.substring(0,3)+"....";
                        }
                        catch (StringIndexOutOfBoundsException str_index_out_Ex){

                        }

                    }
                    logger.log();
                    logger.log();
                     logger.log("EXEC/Mixin", "CS ::/>"+KeyEvent.getKeyText(e.getKeyCode())+"<--EVENT","[BEGIN---TLogger---> ("+trimmed_command+")");
                   // passHandling(trimmed_command,TConsoleFileSystem.readFileForSpecific(trimmed_command,new File("command.dat")));
                    passHandling(trimmed_command,TConsoleFileSystem.readFileForSpecific(trimmed_command,new File("command.dat")));
                    execConsoleNameSpace(command,"");
                    TConsoleCommandParser.parse(TConsoleComponentBridge.input_text_area.getText());
                    TConsoleComponentBridge.input_text_area.setText("");
                    logger.log("EXEC/Mixin","CS ENTER EVENT","["+"END"+"---TLogger---"+trimmed_command+"]");
                }
            }
        });
        super.settings_listener_key();
    }
    @Override
    public void setFontThings() {
        this.setFont(registerFont("lucon.ttf").deriveFont(35f));
        super.setFontThings();
    }
    public void passHandling(String s,boolean go){
        if (go){
            classicConsoleNameSpace(s);
        }else{
            notValidConsoleNameSpace(s);
        }
    }
    public void systemOutConsoleNameSpace(String str){
        System.out.println("TConsole/System.out> "+str);
    }
    public void execConsoleNameSpace(String executed_command,String str){
        logger.log("TConsole/Exec./"+executed_command+">"+str);
    }
    public void notValidConsoleNameSpace(String str){
        logger.log("TConsole/cannot resolve this token> "+str);
    }
    public void classicConsoleNameSpace(String str){
        logger.log("TConsole/>"+ str+"  dscr.-> "+getDescriptionForName(str));
    }
    public String getDescriptionForName(String str){
        switch (str){
            case "cancel":{
                return "cancel the procces for file creating";
            }
            case "path_name":{
                return "it doesnt have a default command it is a path isnt it?";
            }
            case "create":{
                return "creates file,but it wants a path for it you can insert path or cancel the process.";
            }
            case "clear":{
                return "clears all text in the console,and sets text to a updated time.";
            }
            case "get_logger":{
                return "logs all text on the textarea";
            }
            case "debug_mode":{
                return "you can activate debug mod by inserting true or false.";
            }

            default: return "this token doesn't have a description.";
        }
    }

}
