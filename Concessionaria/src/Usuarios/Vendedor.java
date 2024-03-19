package Usuarios;

import Exceptions.AcessoNegadoException;
import Exceptions.OpcaoInvalidaException;

public class Vendedor extends Funcionario{
    public Vendedor(String nome, String usuario, String senha, double salario, long codigo) {
        super(nome, usuario, senha, salario, codigo, 0.01);
    }

    @Override
    public String menu() {
        return super.menu() + "\n4 - Vender Veiculo\n5 - Procurar Cliente\n6 - Ver pagamento";
    }

    @Override
    public void verificarOpcao(int opcao) throws AcessoNegadoException, OpcaoInvalidaException {
        super.verificarOpcao(opcao);
        if(opcao > 6){
            throw new AcessoNegadoException();
        }
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "" +super.toString() +
                "}";
    }
}
