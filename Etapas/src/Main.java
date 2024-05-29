public class Main {
    public static void main(String[] args) {
        Executor executor = new Executor();
        Thread thread1 = new Thread(new Etapa1(executor));
        Thread thread2 = new Thread(new Etapa2(executor));
        Thread thread3 = new Thread(new Etapa3(executor));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}