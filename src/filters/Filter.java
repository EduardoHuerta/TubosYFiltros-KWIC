package filters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public abstract class Filter {

    protected Pipe input,output;   //Declaramos una tuberia para entrada
                                   //Declaramos una tuberia para salida

    public Filter(Pipe in, Pipe out){
        this.input = in;
        this.output = out;
    }

    public Filter(String in, Pipe out){ output = out;} //Este es para el primer filtro que recibe los datos
                                                // y manda al siguiente filtro

    public Filter(Pipe in){ input = in; } // Este constructor es para el filtro de salida

    public abstract void run();

}
