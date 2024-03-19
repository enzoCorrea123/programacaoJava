package Usuarios;

import Veiculos.Veiculo;

public interface IFuncionario extends IUsuario {
    void vender(Veiculo veiculo, Usuario cliente);
    Usuario buscarUsuario(String usuario);

    String verPagamento();
}
