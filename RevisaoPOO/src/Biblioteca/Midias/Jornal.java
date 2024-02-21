package Biblioteca.Midias;

import Biblioteca.Midia;

public class Jornal extends Midia {
    private String data;

    public Jornal(String data, int codigo) {
        this.data = data;
        super.setCodigo(codigo);
        super.setEmprestado(true);
    }

    @Override
    public String toString() {
        return "Jornal{" +
                "data='" + data + '\'' +
                '}';
    }
}
