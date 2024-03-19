package Usuarios;

import Exceptions.AcessoNegadoException;
import Exceptions.OpcaoInvalidaException;

public class Cliente extends Usuario{
    public Cliente(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }

    @Override
    public String menu() {
        return super.menu();
    }

    @Override
    public void verificarOpcao(int opcao) throws AcessoNegadoException, OpcaoInvalidaException {
        super.verificarOpcao(opcao);
        if(opcao > 3){
            throw new AcessoNegadoException();
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "" + super.toString() +
                "}";
    }
}
