package main.command.parser;

import main.command.executer.TConsoleCreateFile;
import main.command.executer.TConsoleFileSystem;
import main.components.TConsoleTextAreaInputWindow;
import main.components.component_bridge.TConsoleComponentBridge;
import main.components.pattern.TCComponentPatternTextArea;
import main.logging.TLogger;
import main.util.integer.TConsoleIntegerUtil;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.io.IOException;

import static main.components.component_bridge.TConsoleComponentBridge.logger;

public class TConsoleCommandParser {
    public static TConsoleCommandParser parse = new TConsoleCommandParser();
    public static TConsoleIntegerUtil integerUtil = new TConsoleIntegerUtil();
    public static TConsoleCreateFile fileSystem;
    public static boolean exitWanted = false;

    public static boolean createWanted = false;

    public static boolean debugModeWanted =false;
    public static void parse(String sCommand){
        try {
            String sCommandUtil = sCommand.trim();
            mathExec(sCommandUtil);
            coreExec(sCommandUtil);
            logExec(sCommandUtil);
            modeExec(sCommandUtil);
        }
        catch(StringIndexOutOfBoundsException e){

        }


    }
    public static void goMathLog(Double d){
        logger.log(integerUtil.wrapToLoggerInteger(d));
    }
    public static void mathExec(String sCommandUtil){
        if (sCommandUtil.lastIndexOf("+")>0){
            double first_int_t = Integer.parseInt(sCommandUtil.substring(0,sCommandUtil.indexOf("+")).trim());
            double second_int_t = Integer.parseInt(sCommandUtil.substring(sCommandUtil.indexOf("+")+1).trim());
           goMathLog(first_int_t+second_int_t);
        }
        if (sCommandUtil.lastIndexOf("-")>0){
            double first_int_t = Integer.parseInt(sCommandUtil.substring(0,sCommandUtil.indexOf("-")).trim());
            double second_int_t = Integer.parseInt(sCommandUtil.substring(sCommandUtil.indexOf("-")+1).trim());
            goMathLog(first_int_t-second_int_t);
        }
        if (sCommandUtil.lastIndexOf("/")>0){
            double first_int_t = Integer.parseInt(sCommandUtil.substring(0,sCommandUtil.indexOf("/")).trim());
            double second_int_t = Integer.parseInt(sCommandUtil.substring(sCommandUtil.indexOf("/")+1).trim());
            goMathLog(first_int_t/second_int_t);
        }
        if (sCommandUtil.lastIndexOf("*")>0){
            double first_int_t = Integer.parseInt(sCommandUtil.substring(0,sCommandUtil.indexOf("*")).trim());
            double second_int_t = Integer.parseInt(sCommandUtil.substring(sCommandUtil.indexOf("*")+1).trim());
            goMathLog(first_int_t*second_int_t);
        }
        if (sCommandUtil.lastIndexOf("square")>0){
            double first_int_t = Integer.parseInt(sCommandUtil.substring(0,sCommandUtil.indexOf("square")).trim());
            goMathLog(first_int_t*first_int_t);
        }
    }
    public static void coreExec(String sCommand){
        String sCommandTrimmed = sCommand.trim();
        if (sCommandTrimmed.equals("exit") || sCommandTrimmed.equals("Exit") || sCommandTrimmed.equals("EXIT") || sCommandTrimmed.equals("ext")) {
            exitWanted = true;
            TConsoleComponentBridge.input_text_area.systemOutConsoleNameSpace("Are you sure? y/yes n/no");
        } else if (sCommandTrimmed.equals("yes") && exitWanted) {
            System.exit(0);
        } else if (sCommandTrimmed.equals("no") && exitWanted) {
            TConsoleComponentBridge.input_text_area.systemOutConsoleNameSpace("exit want is canceled.");
            exitWanted = false;
        }
        if (sCommandTrimmed.equals("create")){
            createWanted = true;
            TConsoleComponentBridge.input_text_area.systemOutConsoleNameSpace("Set The Path::");
        } else if (sCommandTrimmed.length()>0&&createWanted&&!sCommandTrimmed.equals("cancel")) {
            fileSystem = new TConsoleCreateFile(sCommandTrimmed);
            try {
                TConsoleComponentBridge.input_text_area.systemOutConsoleNameSpace("file create exc. return-> "+fileSystem.createNewFile());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (sCommandTrimmed.equals("cancel")&&createWanted) {
            createWanted  = false;
            TConsoleComponentBridge.input_text_area.systemOutConsoleNameSpace("file create want canceled.");
        }
        if (sCommandTrimmed.equals("clear")){
            TConsoleComponentBridge.main_text_area.setText("");
        }

    }

    public static void logExec(String sCommand){
        if (sCommand.equals("get_logger")){
            logger.saveLogsToFile();
        }
    }
    public static void modeExec(String sCommand){
        if (sCommand.equals("debug_mode")){
            debugModeWanted = true;
            TConsoleComponentBridge.input_text_area.systemOutConsoleNameSpace("value?= ");
        }else if(debugModeWanted&&sCommand.equals("true")){
            TConsoleTextAreaInputWindow.debugMode = true;
        } else if (debugModeWanted&&sCommand.equals("false")) {
            TConsoleTextAreaInputWindow.debugMode = false;
        }
    }


}
