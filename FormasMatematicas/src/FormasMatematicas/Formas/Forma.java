package FormasMatematicas.Formas;

import java.util.ArrayList;

public abstract class Forma {
    protected static ArrayList<Forma> listaDeFormas = new ArrayList<>();

    public abstract double area();
    public abstract double perimetro();

    public void AdicionarForma(Forma forma){
        listaDeFormas.add(forma);
    }

    public ArrayList<Forma> getListaDeFormas() {
        return listaDeFormas;
    }

    public void removerForma(Forma forma){
        listaDeFormas.remove(forma);
    }
    public void removerTodasFormas(){
        listaDeFormas.clear();
    }
    public abstract String listar();


}
