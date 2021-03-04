package filters;

import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String file;
        JFileChooser jFC = new JFileChooser();
        jFC.setDialogTitle("KWIC - Seleccione el archivo de entrada deseado");
        jFC.setCurrentDirectory(new File("src"));
        int res = jFC.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            file = jFC.getSelectedFile().getPath();
        } else {
            file = "src/input.txt";
        }

        Pipe inputToCircular = new Pipe();
        Pipe circularShifterToAlphabetizer = new Pipe();
        Pipe alphabetizerToOutput = new Pipe();

        Filter input = new Input(file, inputToCircular);
        Filter shifter = new CircularShift(inputToCircular, circularShifterToAlphabetizer);
        Filter alpha = new Alphabetizer(circularShifterToAlphabetizer, alphabetizerToOutput);
        Filter output = new Output(alphabetizerToOutput);

        input.start();
        shifter.start();
        alpha.start();
        output.start();
    }
}
