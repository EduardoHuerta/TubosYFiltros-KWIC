package filters;

public abstract class Filter {

    protected Pipe input,output;   //Declaramos una tuberia para entrada
                                   //Declaramos una tuberia para salida

    public Filter(Pipe in, Pipe out){
        this.input = in;
        this.output = out;
    }

    public abstract void transform();

}
