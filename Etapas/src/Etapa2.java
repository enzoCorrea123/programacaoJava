public class Etapa2 implements Runnable{

    public Executor executor;

    public Etapa2(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void run() {
        executor.executar(2);

    }
}
