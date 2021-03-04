package filters;

public abstract class Filter implements Runnable {

    protected Pipe input,output;   //Declaramos una tuberia para entrada
                                   //Declaramos una tuberia para salida

    public Filter(Pipe in, Pipe out){
        input = in;
        output = out;
    }

    private boolean isStarted = false;

    public void start() {
        if (!isStarted) {
            isStarted = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        transform();
    }

    public abstract void transform();
}
