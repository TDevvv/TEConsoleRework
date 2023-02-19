package main.outstream;

import main.printstream.TCPrintStream;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class TCOutputStream extends OutputStream {

        private JTextArea textArea;

        public TCOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
            // keeps the textArea up to date
            //textArea.update(textArea.getGraphics());
        }

}
