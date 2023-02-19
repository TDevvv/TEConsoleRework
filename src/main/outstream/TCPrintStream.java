package main.outstream;

import java.io.OutputStream;
import java.io.PrintStream;

public class TCPrintStream extends PrintStream {
    public TCPrintStream(OutputStream out) {
        super(out);
    }
    public void println(String x,Class c){
        super.println("["+c.getSimpleName()+"]->");
        super.println(x);
    }
}
