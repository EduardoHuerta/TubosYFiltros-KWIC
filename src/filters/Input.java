package filters;

import java.io.*;

public class Input extends Filter { //Heredamos la clase abstracta Filter para tomar como filtro a la clase Input

    String file;

    public Input(String filtroInput, Pipe outputDelFiltroInput) {
        super(filtroInput, outputDelFiltroInput);
        file = filtroInput;
    }

    public void run(){
        try {
            System.out.println("Filtro de entrada trabajando con los datos de entrada");
            BufferedReader br =  new BufferedReader(new FileReader(file));
            String linea = null;
            while ((linea = br.readLine()) != null){
                output.write(linea + '\n');
            }
            output.closeWriter();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
