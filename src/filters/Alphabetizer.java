package filters;

import java.io.IOException;
import java.util.Arrays;

public class Alphabetizer extends Filter{

    public Alphabetizer(Pipe in, Pipe out){
        super(in, out);
    }

    public void run() {
        try {
            System.out.println("Filtro Alphabetizer en el se estan ordenando las sentencias");
            String[] shiftedLines = input.read().trim().split("\\n");

            Arrays.sort(shiftedLines, String.CASE_INSENSITIVE_ORDER);  // se utiliza una coleccion para el ordenamiento automatico

            for(String str : shiftedLines) {
                output.write(str + "\n");
            }
            output.closeWriter();
        } catch (IOException e) {
            System.out.println("No se pudieron ordenar los datos");
        }
    }
}
