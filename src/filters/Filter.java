package filters;

public abstract class Filter implements Runnable{

    protected Pipe input,output;   //Declaramos una tuberia para entrada
                                   //Declaramos una tuberia para salida

    long initialTime = System.currentTimeMillis();

    public Filter(Pipe in, Pipe out){
        input = in;
        output = out;
    }
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
        System.out.println("EJECUTANDO.... "+ thread.currentThread().getName());
    }

    @Override
    public void run() {
        transform();
        System.out.println((System.currentTimeMillis() - initialTime)	+ "milisegs" );
    }
    public abstract void transform();
}
