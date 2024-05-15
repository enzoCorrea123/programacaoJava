import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Teatro implements Runnable{
    private final boolean[] assento = new boolean[50];

    public Teatro() {
        Arrays.fill(assento, false);
    }
    public synchronized void reservarAssento(int lugar){
        if(!assento[lugar]){
            assento[lugar] = true;
            System.out.println("Número de assento " + lugar + " foi reservado com sucesso");
        }else{
            System.out.println("Não é possível reservar esse assento "+lugar);
        }
    }

    @Override
    public void run() {
        Random rand = new Random();
        int lugar = rand.nextInt(50);
        reservarAssento(lugar);
    }
}
