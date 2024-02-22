package Biblioteca.Usuarios;

import Biblioteca.Midia;

public class Cliente extends Usuario {
    public Cliente(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }

    @Override
    protected boolean addEmprestimo(Midia midia){
        if(!midia.isEmprestado()){
            emprestimos.add(midia);
            return true;
        }
        return false;
    }

}
