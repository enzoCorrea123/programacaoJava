public class Controller {

    public void executar(){
        Teatro teatro = new Teatro();
        Thread reserva1 = new Thread(teatro);
        Thread reserva2 = new Thread(teatro);
        Thread reserva3 = new Thread(teatro);
        Thread reserva4 = new Thread(teatro);

        reserva1.start();
        reserva2.start();
        reserva3.start();
        reserva4.start();
    }

}
