package main.util.ready;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TConsoleReadyDate extends Date {
    public static TConsoleReadyDate INSTANCE = new TConsoleReadyDate();

    public static String defaultConsoleFormat = "[yyyy-MM-dd-hh-mm-ss]";
    public static String defaultFileFormatLong = "yyyy_MM_dd_hh_mm_ss";
    public  TConsoleReadyDate(){

    }
    public static String getDateWithPattern(String pattern){
        SimpleDateFormat format;
        if (pattern==null){
         format = new SimpleDateFormat(defaultConsoleFormat);
        }else{
         format = new SimpleDateFormat(pattern);
        }
        return format.format(new Date());
    }
}
