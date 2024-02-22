package Biblioteca.Midias;

import Biblioteca.Midia;

public class Revista extends Midia {
    private String editora;
    private String genero;

    public Revista(String editora, String genero, int codigo) {
        this.editora = editora;
        this.genero = genero;
        super.setCodigo(codigo);
        super.setEmprestado(false);
    }

    @Override
    public String toString() {
        return "Revista{" +
                "editora='" + editora + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
