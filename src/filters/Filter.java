package filters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class Filter {

    protected Pipe input,output;   //Declaramos una tuberia para entrada
                                   //Declaramos una tuberia para salida

    Filter(Pipe in, Pipe out){
        this.input = in;
        this.output = out;
    }

    Filter(FileInputStream in, Pipe out){ //Este es para el primer filtro que recibe los datos
        output = out;                     //y manda al siguiente filtro
    }

    Filter(Pipe in){
        input = in;
    } // Este constructor es para el filtro de salida y ultimo, que solo recibe los
                                    //datos de la tuberia o pipe

    public abstract void run();

    public String read() throws IOException {
        return input.read();
    }

}
