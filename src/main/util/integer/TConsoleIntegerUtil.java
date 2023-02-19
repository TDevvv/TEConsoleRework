package main.util.integer;

import main.components.TConsoleTextAreaInputWindow;
import main.components.component_bridge.TConsoleComponentBridge;
import main.logging.TLogger;
import static main.components.component_bridge.TConsoleComponentBridge.logger;

public class TConsoleIntegerUtil<T extends Object> {
    public static final TLogger main_logger = logger;

    public  String wrapToLoggerInteger(T value) {
        String wrapeedInt = String.valueOf(value);
        return wrapeedInt;

    }
}
