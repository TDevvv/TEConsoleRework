package main.command.executer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TConsoleFileSystem {

    private static Scanner scanner;

    {


    }


    public static boolean readFileForSpecific(String spc, File file) {
        boolean rtr = false;
        try {
            scanner = new Scanner(file);
            for (int i = 0; i < 7;i++) {
              if (scanner.nextLine().trim().equals(spc)){
                  rtr = true;
              }
                   // rtr = scanner.nextLine().equals(spc);
            }

        }
        catch (FileNotFoundException e){


        }
        return rtr;
    }


}
