package filters;

public abstract class Filter implements Runnable {

    protected Pipe input,output;   //Declaramos una tuberia para entrada
                                   //Declaramos una tuberia para salida

    public Filter(Pipe in, Pipe out){
        input = in;
        output = out;
    }

    public void start() {
        Thread thread = new Thread(this);
        System.out.println("Hilo:" +thread.getName() + "iniciando");
        thread.start();
    }

    @Override
    public void run() {
        transform();
    }

    public abstract void transform();
}
