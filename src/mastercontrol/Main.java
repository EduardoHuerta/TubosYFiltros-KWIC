package mastercontrol;

import filters.*;

import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String file;
        JFileChooser jFC = new JFileChooser();
        jFC.setDialogTitle("KWIC - Seleccione el archivo de datos deseado");
        jFC.setCurrentDirectory(new File("src"));
        int res = jFC.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            file = jFC.getSelectedFile().getPath();
        } else {
            file = "src/inputFile.txt";
        }
        Main kwic = new Main();
        kwic.execute(file);
    }

    public void execute(String file) throws IOException {

        Pipe inputToCircular = new Pipe();
        Pipe circularShifterToAlphabetizer = new Pipe();
        Pipe alphabetizerToOutput = new Pipe();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream archivoDeEntrada = new FileInputStream(file);

        Filter input = new Input(archivoDeEntrada, inputToCircular);
        Filter shifter = new CircularShift(inputToCircular, circularShifterToAlphabetizer);
        Filter alpha = new Alphabetizer(circularShifterToAlphabetizer, alphabetizerToOutput);
        Filter output = new Output(alphabetizerToOutput);

        input.run();
        shifter.run();
        alpha.run();
        output.run();

    }
}
