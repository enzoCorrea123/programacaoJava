public class Etapa1 implements Runnable{

    public Executor executor;
    public Etapa1(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void run() {
        executor.executar(1);
    }
}
