package main.command.executer;

import main.util.ready.TConsoleReadyDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class TCFileWriter extends FileWriter {
    String path;

    public TCFileWriter(File file) throws IOException {

        super(file);
        path =file.getAbsolutePath();
    }

    public void saveToFile(String s){
        try {
            this.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            this.write("FILE SAVED ON /*- "+ TConsoleReadyDate.getDateWithPattern(TConsoleReadyDate.defaultConsoleFormat)+" Path:: "+path);
            this.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
