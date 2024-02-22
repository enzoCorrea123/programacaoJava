package Biblioteca.Midias;

import Biblioteca.Midia;

public class DVD extends Midia {
    private String diretor;
    private String nomeFilme;

    public DVD(String diretor, String nomeFilme, int codigo) {
        this.diretor = diretor;
        this.nomeFilme = nomeFilme;
        super.setCodigo(codigo);
        super.setEmprestado(false);
    }

    @Override
    public String toString() {
        return "DVD{" +
                "diretor='" + diretor + '\'' +
                ", nomeFilme='" + nomeFilme + '\'' +
                '}';
    }
}
