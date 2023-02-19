package run;

import main.TConsoleMainWindow;
import main.components.TConsoleTextAreaInputWindow;
import main.components.TConsoleTextAreaMainWindow;
import main.components.TConsoleEditorWindowPanel;
import main.frames.TConsoleInputWindow;
import main.listeners.key.TCKeyEvents;

public class TConsoleRunner {
    public static TConsoleMainWindow console;
    public static TConsoleInputWindow console_input;

    public static TConsoleTextAreaMainWindow  console_text_area;

    public static TConsoleTextAreaInputWindow console_input_text_area;
    public static void main(String[] args) {
        console = new TConsoleMainWindow("TConsole");
        console_input = TCKeyEvents.window;
        console_text_area = TConsoleMainWindow.tConsoleTextArea;
        console_input_text_area = TConsoleInputWindow.getTextAreaInputWindow();

    }
}
