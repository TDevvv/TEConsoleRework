package main.components.component_bridge;

import main.TConsoleMainWindow;
import main.components.TConsoleTextAreaInputWindow;
import main.components.TConsoleTextAreaMainWindow;
import main.frames.TConsoleInputWindow;
import main.logging.TLogger;
import run.TConsoleRunner;

import java.awt.*;

public class TConsoleComponentBridge {
      public static  TConsoleInputWindow input_window = TConsoleRunner.console_input;
      public static TConsoleMainWindow main_window = TConsoleRunner.console;

      public static final TConsoleTextAreaMainWindow main_text_area = TConsoleRunner.console_text_area;
      public static final TConsoleTextAreaInputWindow input_text_area =TConsoleRunner.console_input_text_area;

      public static final TLogger logger = new TLogger(TConsoleComponentBridge.class);

}
