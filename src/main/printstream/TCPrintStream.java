package main.printstream;

import java.io.OutputStream;
import java.io.PrintStream;

public class TCPrintStream extends PrintStream {
    public TCPrintStream(OutputStream out) {
        super(out);
    }

}
