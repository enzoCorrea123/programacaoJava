package FormasMatematicas.Formas;

import java.util.ArrayList;

public abstract class Forma {
    protected ArrayList<Forma> listaDeFormas = new ArrayList<>();

    public abstract double area();
    public abstract double perimetro();

    public void AdicionarForma(Forma forma){
        listaDeFormas.add(forma);
    }
    public void removerForma(Forma forma){
        listaDeFormas.remove(forma);
    }
    public void removerTodasFormas(){
        listaDeFormas.clear();
    }
    public abstract void listar();


}
