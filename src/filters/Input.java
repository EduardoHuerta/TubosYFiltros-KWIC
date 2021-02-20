package filters;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Input extends Filter { //Heredamos la clase abstracta Filter para tomar como filtro a la clase Input

    FileInputStream fileIn;
    private BufferedReader reader;

    public Input(FileInputStream filtroInput, Pipe outputDelFiltroInput) {
        super(filtroInput, outputDelFiltroInput);
        fileIn = filtroInput;
    }


    public void run(){
        try {
            byte[] bytes = fileIn.readAllBytes();
            String s = new String(bytes, StandardCharsets.UTF_8);
            output.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
