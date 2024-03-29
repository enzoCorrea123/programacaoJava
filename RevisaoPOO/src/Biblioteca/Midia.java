package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Midia {
    private static final ArrayList<Midia> midias = new ArrayList<>();
    private int codigo;
    private boolean emprestado;

    public static Midia procurarMidia(int codigo) {
        for(Midia midia: midias){
            if(midia.codigo == codigo){
                return midia;
            }
        }
        return null;
    }

    public static List<Midia> getMidias(){
        return Collections.unmodifiableList(midias);
    }
    @Override
    public String toString() {
        return "Midia{" +
                "codigo=" + codigo +
                ", emprestado=" + emprestado +
                '}';
    }

    public static void addMidia(Midia midia){
        midias.add(midia);
    }
    public static void removeMidia(int codigo){
        for(Midia midia: midias){
            if(midia.codigo == codigo){
                midias.remove(midia);
                return;
            }
        }
    }

    public boolean isEmprestado() {
        return emprestado;
    }
    public void alterarEmprestimo(){
        this.emprestado = !this.emprestado;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
