package main.logging;

import main.command.executer.TCFileWriter;
import main.command.executer.TConsoleCreateFile;
import main.util.ready.TConsoleReadyDate;
import main.util.text.TConsoleTextUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TLogger {
    protected final Class aClass;
    public TLogger(Class c){
        aClass = c;
    }
    public static final HashMap<Integer,String> list = new HashMap<>();
    int j = 0;
    public void log(String LEVEL,String str,String PageSplitter){
        j++;
        System.out.println(PageSplitter+"["+LEVEL+"] /"+TConsoleTextUtil.setBrackedRect(TConsoleReadyDate.getDateWithPattern(null))+" "+TConsoleTextUtil.setBrackedCurly(aClass.getSimpleName())+" "+TConsoleTextUtil.setBracked(str));
        list.put(j,PageSplitter+"["+LEVEL+"] /"+TConsoleTextUtil.setBrackedRect(TConsoleReadyDate.getDateWithPattern(null))+" "+TConsoleTextUtil.setBrackedCurly(aClass.getSimpleName())+" "+TConsoleTextUtil.setBracked(str));
    }
    public void log(String STR){
        j++;
        System.out.println(STR);
        list.put(j,STR);
    }
    public void log(){
        j++;
        System.out.println();
        list.put(j,"");
    }
    public void saveLogsToFile(){
        try {
            TConsoleCreateFile log_directory = new TConsoleCreateFile("logs");
            Boolean booleas = log_directory.mkdirs();
           System.out.println("directory create return /> "+booleas.booleanValue()+" path::"+log_directory.getAbsolutePath());
            TConsoleCreateFile newfile = new TConsoleCreateFile("logs\\log"+TConsoleReadyDate.getDateWithPattern(TConsoleReadyDate.defaultFileFormatLong)+".log");
            TCFileWriter fileWriter = new TCFileWriter(newfile);
            for (String s:
                    list.values()) {
                fileWriter.write(s);
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
