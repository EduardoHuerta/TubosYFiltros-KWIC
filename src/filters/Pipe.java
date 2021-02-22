package filters;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;

public class Pipe {

    private PipedReader reader;
    private PipedWriter writer;

    public Pipe() throws IOException {
        writer = new PipedWriter();
        reader = new PipedReader();
        writer.connect(reader);
    }


    public void write(String s) throws IOException {
        writer.write(s);
    }

    public String read() throws IOException {
        int data;
        StringBuilder sb = new StringBuilder();
        while((data = reader.read()) != -1) {
            sb.append((char) data);
        }
        reader.close();
        return sb.toString();
    }

    public void closeWriter() throws IOException {
        writer.flush();
        writer.close();
    }
    public void closeReader() throws IOException {
        reader.close();
    }
}
