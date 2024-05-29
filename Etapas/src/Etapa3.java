public class Etapa3 implements Runnable{
    public boolean executado3;
    public Executor executor;

    public Etapa3(Executor executor) {
        this.executado3 = false;
        this.executor = executor;
    }

    public void executarTarefa(){
        System.out.println("Etapa 3 executada por Thread 3");
        this.executado3 = true;
        notify();
    }

    @Override
    public void run() {
        executor.executar(3);
    }
}
