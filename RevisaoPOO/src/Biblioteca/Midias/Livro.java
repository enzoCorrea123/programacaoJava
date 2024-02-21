package Biblioteca.Midias;

import Biblioteca.Midia;

public class Livro extends Midia {
    private String autor;
    private String titulo;
    private String genero;

    public Livro(String autor, String titulo, String genero, int codigo) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        super.setCodigo(codigo);
        super.setEmprestado(true);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
