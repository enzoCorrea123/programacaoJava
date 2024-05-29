public class Executor{
    public int executado = 1;
    public synchronized void executar(int executaTarefa){
        try{
            while (executado != executaTarefa){
                wait();
            }
        } catch (Exception e){
            throw new RuntimeException("Deu ruim");
        }
        System.out.println("Etapa" + executado + " foi executada");
        executado += 1;
        notify();

    }

}
