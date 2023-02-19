package main.util.ready;

public class TConsoleReady {
    public final static DefaultConsole defaultConsole = new DefaultConsole();
    public final static InputConsole inputConsole = new InputConsole();

    public static int getInputConsoleWidth(){
        return InputConsole.Width;
    }
    public static int getInputConsoleHeight(){
        return InputConsole.Height;
    }
    public static int getDefaultConsoleWidth(){
        return DefaultConsole.Width;
    }
    public static int getDefaultConsoleHeight(){
    return DefaultConsole.Height;
    }
static class DefaultConsole{
    protected static int Width = 1200;
    protected static int Height = 700;

}
static class InputConsole{
        protected  static int Width = 1200;
        protected static int Height = 90;
}
}

